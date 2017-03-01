<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">




var AM_markers = new Map();




/*globals $,google,MarkerClusterer,MarkerWithLabel */
/**
 * jQuery tinyMap plugin
 * https://code.essoduke.org/tinyMap/
 * Copyright 2016 essoduke.org, Licensed MIT.
 *
 * Changelog
 * -------------------------------
 * markerWithLabel 參數可支援整數，表示只顯示以地圖中心為圓心的半徑範圍的 label。（需配合 Geometry libraries）
 *
 * @author Essoduke Chang<essoduke@gmail.com>
 * @license MIT License
 */
/**
 * Call while google maps api loaded
 * @callback
 */
window.gMapsCallback = function () {
    $(window).trigger('gMapsCallback');
};
/**
 * Plugin statements
 */
;(function ($, window, document, undefined) {
	
	
	// ==== tinymap_head_setting ====
	<%@include file="/front-end/google_map/js/tinymap_head_setting.js"%>
	
	
    /**
     * Recursively iterate for replace google.maps constants
     * @param {Mixed} obj Object
     * @since 3.3.16
     */
    function scan (obj) {
        var i = 0, prop, m;
        if (obj instanceof Array) {
            for (i = 0; i < obj.length; i += 1) {
                scan(obj[i]);
            }
        } else if ('object' === typeof obj) {
            for (prop in obj) {
                if (!('string' === typeof obj[prop])) {
                    scan(obj[prop]);
                } else if (/^google\.map/gi.test(obj[prop])) {
                    m = obj[prop].split('.');
                    if (4 === m.length) {
                        obj[prop] = google.maps[m[2]][m[3]];
                    }
                }
            }
        }
    }
    /**
     * Parsing the location
     * @param {(string|string[]|number[]|Object)} loc Location
     * @param {boolean} formatting Format to Google Maps LatLng object
     * @private
     */
    function parseLatLng (loc, formatting) {

        var result = {
                'lat': '',
                'lng': ''
            },
            array = [],
            re = /^[+-]?\d+(\.\d+)?$/;

        if ('string' === typeof loc || Array.isArray(loc)) {
            array = Array.isArray(loc) ? loc : loc.toString().replace(/\s+/, '').split(',');
            if (2 === array.length) {
                if (re.test(array[0]) && re.test(array[1])) {
                    result.lat = array[0];
                    result.lng = array[1];
                }
            } else {
                return loc;
            }
        } else if ('object' === typeof loc) {
            // Google LatLng Class
            if ('function' === typeof loc.lat) {
                return loc;
            } else if (loc.hasOwnProperty('x') && loc.hasOwnProperty('y')) {
                result.lat = loc.x;
                result.lng = loc.y;
            } else if (loc.hasOwnProperty('lat') && loc.hasOwnProperty('lng')) {
                result.lat = loc.lat;
                result.lng = loc.lng;
            }
        }

        // Location offset
        // @since v3.4.4
        result.lat = parseFloat(result.lat, 10) + ((Math.random() - 0.5) / 5000);
        result.lng = parseFloat(result.lng, 10) + ((Math.random() - 0.5) / 5000);

        if (true === formatting) {
            return new google.maps.LatLng(result.lat, result.lng);
        }
        return result;
    }
    //#!#START LABEL
    /**
     * Label in Maps
     * @param {Object} options Label options
     * @protected
     */
    function Label (options) {
        var self = this,
            css = options.hasOwnProperty('css') ? options.css.toString() : '';
        self.setValues(options);
        self.span = $('<span/>').css({
            'position': 'relative',
            'left': '-50%',
            'top': '0',
            'white-space': 'nowrap'
        }).addClass(css);
        self.div = $('<div/>').css({
            'position': 'absolute',
            'display': 'none'
        });
        self.span.appendTo(self.div);
    }
    //#!#END
    
	<%@include file="/front-end/google_map/js/tinymap_map_setting.js"%>
    
    /**
     * TinyMap prototype
     */
    TinyMap.prototype = {

        /**
         * Current version
         * @type {string}
         * @constant
         */
        'VERSION': '3.4.6',

        <%@include file="/front-end/google_map/js/tinymap_prototye_format.jsp"%>
        ,
        <%@include file="/front-end/google_map/js/tinymap_prototye_overlay.jsp"%> 
        , 
        <%@include file="/front-end/google_map/js/tinymap_prototye_bindEvents.jsp"%> 
        , 
        <%@include file="/front-end/google_map/js/tinymap_prototye_KML.jsp"%> 
		,
      	//#!#START POLYLINE
		<%@include file="/front-end/google_map/js/tinymap_prototye_drawPoly.jsp"%> 
		,
        //#!#END
        //#!#START MARKER
        <%@include file="/front-end/google_map/js/tinymap_prototye_marker_icon.jsp"%>
		,
		<%@include file="/front-end/google_map/js/tinymap_prototye_marker_processMarker.jsp"%>
 		,
		<%@include file="/front-end/google_map/js/tinymap_prototye_marker_markerControl.jsp"%>
		,
        /**
         * Place markers layer.
         * @param {Object} map Map instance
         * @param {Object} opt Markers options
         * @param {string} source Mode
         */
        placeMarkers: function (map, opt, source, mks) {

            var self           = this,
                geocoder       = {},
                clusterOptions = {
                    'maxZoom' : null,
                    'gridSize': 60
                },
                markers = Array.isArray(opt.marker) ? opt.marker : [],
                tmks   = [],
                oms    = {},
                hasOMS = false,
                tOut,
                iconWithColor = function(color) {
                    return 'https://chart.googleapis.com/chart?chst=d_map_xpin_letter&chld=pin|+|' + color + '|000000|ffff00';
                };

            if ('undefined' !== typeof mks && Array.isArray(mks) && mks.length) {
                markers = mks;
            }

            /**
             * Apply marker cluster.
             * Require markerclustererplus.js
             * @see {@link http://google-maps-utility-library-v3.googlecode.com/svn/trunk/markerclustererplus/docs/reference.html}
             * @since 2015-04-30 10:18:33
             */
            if (self.options.hasOwnProperty('markerCluster')) {
                if ('function' === typeof MarkerClusterer) {
                    clusterOptions = $.extend({}, clusterOptions, opt.markerCluster);
                    self._clusters = new MarkerClusterer(map, [], clusterOptions);
                    if (clusterOptions.hasOwnProperty('event')) {
                        self.bindEvents(self._clusters, clusterOptions.event);
                    }
                }
            }

            if (self.options.hasOwnProperty('enableOMS') && 'function' === typeof OverlappingMarkerSpiderfier) {
                hasOMS = true;
            }

            if (hasOMS) {

                oms = new OverlappingMarkerSpiderfier(map, {
                    'markersWontHide': true
                });
                oms.addListener('click', function (marker) {
                        if (marker.hasOwnProperty('oms')) {
                            marker.infoWindow.setContent(marker.oms);
                        }
                        marker.infoWindow.open(map, marker);

                });

                oms.addListener('spiderfy', function (markers) {
                    var i = 0;
                    //for (; i < markers.length; i += 1) {
                        //markers[i].infoWindow.close();
                    //}
                });

                oms.addListener('unspiderfy', function (markers) {
                    var i = 0;
                    //for (i; i < markers.length; i += 1) {
                        //markers[i].infoWindow.close();
                    //}
                });
            }
			<%@include file="/front-end/google_map/js/tinymap_create_marker.js"%>

            /**
             * markerWithLabel radius
             * @since v3.4.6
             */
            if (opt.hasOwnProperty('markerWithLabel') && $.isNumeric(opt.markerWithLabel)) {
                var rebuildLabelsOnIdle = {
                    'idle': {
                        'func': function () {
                            self.clear('label');
                            var loc = map.getCenter(),
                                pool = [];
                            self.get('marker', function (ms) {
                                ms.forEach(function (marker) {
                                    var meters = google.maps.geometry.spherical.computeDistanceBetween(marker.getPosition(), loc);
                                    if (meters < 1000) {
                                        pool.push(marker);
                                    }
                                });
                                if (pool) {
                                    pool.forEach(function (marker) {
                                        var lblOpt = {
                                                'id'  : marker.id,
                                                'text': marker.newLabel,
                                                'map' : map,
                                                'css' : marker.hasOwnProperty('newLabelCSS') ?
                                                        marker.newLabelCSS.toString() :
                                                        ''
                                            },
                                            label = new Label(lblOpt);
                                        label.bindTo('position', marker);
                                        label.set('visible', marker.showLabel);
                                        self._labels.push(label);
                                    });
                                }
                            });
                        },
                        'once': false
                    }
                };
                rebuildLabelsOnIdle.idle.func.apply(self, arguments);
                self.mapIdleEvent(rebuildLabelsOnIdle);
            }
            self.markerControl();
        },
        //#!#END
        //#!#START DIRECTION
        /**
         * Direction overlay
         * @param {Object} map Map instance
         * @param {Object} opt Direction options
         */
        directionService: function (map, opt) {

            var self = this,
                directionsService = new google.maps.DirectionsService();

            if (Array.isArray(opt.direction)) {
                opt.direction.forEach(function (opts) {

                    if ('undefined' === typeof opts.from || 'undefined' === typeof opts.to) {
                        return;
                    }

                    var request = {},
                        directionsDisplay = new google.maps.DirectionsRenderer(),
                        renderOpts = $.extend({}, {
                            'infoWindow': new google.maps.InfoWindow(),
                            'map': self.map
                        }, opts),
                        waypointsOpts = [],
                        waypointsText = [],
                        waypointsIcon = [];

                    request.origin = parseLatLng(opts.from, true);
                    request.destination = parseLatLng(opts.to, true);

                    // TravelMode
                    request.travelMode = opts.hasOwnProperty('travel') && google.maps.TravelMode[opts.travel.toString().toUpperCase()] ?
                                         google.maps.TravelMode[opts.travel.toString().toUpperCase()] :
                                         google.maps.TravelMode.DRIVING;

                    // Info Panel
                    if (opts.hasOwnProperty('panel') && $(opts.panel).length) {
                        renderOpts.panel = $(opts.panel).get(0);
                    }
                    if (opts.hasOwnProperty('requestExtra') && opts.requestExtra) {
                        request = $.extend({}, request, opts.requestExtra);
                    }
                    if (opts.hasOwnProperty('optimize')) {
                        request.optimizeWaypoints = opts.optimize;
                    }
                    // Waypoints
                    if (opts.hasOwnProperty('waypoint') && Array.isArray(opts.waypoint)) {
                        opts.waypoint.forEach(function (waypoint) {
                            var waypointOpt = {
                                'stopover': true
                            };
                            if ('string' === typeof waypoint || Array.isArray(waypoint)) {
                                waypointOpt.location = parseLatLng(waypoint, true);
                            } else if (waypoint.hasOwnProperty('location')) {
                                waypointOpt.location = parseLatLng(waypoint.location, true);
                                waypointOpt.stopover = waypoint.hasOwnProperty('stopover') ?
                                                       waypoint.stopover :
                                                       true;
                            }
                            waypointsText.push(waypoint.text || waypoint.toString());
                            if (waypoint.hasOwnProperty('icon')) {
                                waypointsIcon.push(waypoint.icon.toString());
                            }
                            waypointsOpts.push(waypointOpt);
                        });
                        request.waypoints = waypointsOpts;
                    }

                    // DirectionService
                    directionsService.route(request, function (response, status) {
                        if (status === google.maps.DirectionsStatus.OK) {
                            response.routes.forEach(function (route, index) {
                                // @since 3.3.2 Multiple routes render.
                                if (opts.hasOwnProperty('renderAll') &&
                                    true === opts.renderAll &&
                                    true === request.provideRouteAlternatives
                                ){
                                    var dr = new google.maps.DirectionsRenderer({
                                        'map': map,
                                        'directions': response,
                                        'routeIndex': index
                                    });
                                }

                                var legs = route.legs,
                                    startText = '',
                                    endText = '',
                                    wp = {},
                                    i = 0;

                                if (opts.hasOwnProperty('fromText')) {
                                    legs[0].start_address = opts.fromText;
                                    startText = opts.fromText;
                                }
                                if (opts.hasOwnProperty('toText')) {
                                    if (1 === legs.length) {
                                        legs[0].end_address = opts.toText;
                                    } else {
                                        legs[legs.length - 1].end_address = opts.toText;
                                    }
                                    endText = opts.toText;
                                }
                                if (opts.hasOwnProperty('icon')) {
                                    renderOpts.suppressMarkers = true;
                                    if (opts.icon.hasOwnProperty('from') && 'string' === typeof opts.icon.from) {
                                        self.directionServiceMarker(legs[0].start_location, {
                                            'icon': opts.icon.from,
                                            'text': startText
                                        }, renderOpts.infoWindow, opts);
                                    }
                                    if (opts.icon.hasOwnProperty('to') && 'string' === typeof opts.icon.to) {
                                        self.directionServiceMarker(legs[legs.length - 1].end_location, {
                                            'icon': opts.icon.to,
                                            'text': endText
                                        }, renderOpts.infoWindow, opts);
                                    }
                                }
                                for (i = 1; i < legs.length; i += 1) {
                                    if (opts.hasOwnProperty('icon')) {
                                        if (opts.icon.hasOwnProperty('waypoint') && 'string' === typeof opts.icon.waypoint) {
                                            wp.icon = opts.icon.waypoint;
                                        } else if ('string' === typeof waypointsIcon[i - 1]) {
                                            wp.icon = waypointsIcon[i - 1];
                                        }
                                        wp.text = waypointsText[i - 1];
                                        self.directionServiceMarker(
                                            legs[i].start_location,
                                            wp,
                                            renderOpts.infoWindow,
                                            opts
                                        );
                                    }
                                }
                            });
                            self.bindEvents(directionsDisplay, opts.event);
                            directionsDisplay.setOptions(renderOpts);
                            directionsDisplay.setDirections(response);
                            self._directions.push(directionsDisplay);
                        }
                    });
                });
            }
        },
        /**
         * Create the marker for directions
         * @param {Object} loc LatLng Location
         * @param {Object} opt MarkerOptions
         * @param {Object} info Global infoWindow object
         * @param {Object} d Direction marker options
         */
        directionServiceMarker: function (loc, opt, info, d) {

            var self = this,
                evt = {},
                setting = $.extend({}, {
                    'position': loc,
                    'map': self.map,
                    'id' : d.hasOwnProperty('id') ? d.id : ''
                }, opt),
                marker  = new google.maps.Marker(setting);

            if (setting.hasOwnProperty('text')) {
                evt = function () {
                    info.setPosition(loc);
                    info.setContent(setting.text);
                    info.open(self.map, marker);
                };
            }
            self._directionsMarkers.push(marker);
            self.bindEvents(marker, evt);
        },
        /**
         * Get directions info
         * @return {Array} All directions info includes distance and duration.
         */
        getDirectionsInfo: function () {
            var result = [];
            this.get('direction', function (dr) {
                dr.forEach(function (dc, i) {
                    var d = dc.getDirections();
                    if (d.hasOwnProperty('routes') &&
                        'undefined' !== typeof d.routes[0] &&
                        'undefined' !== typeof d.routes[0].legs
                    ) {
                        result[i] = [];
                        d.routes[0].legs.forEach(function (leg, j) {
                            result[i].push({
                                'from'    : leg.start_address,
                                'to'      : leg.end_address,
                                'distance': leg.distance,
                                'duration': leg.duration
                            });
                        });
                    }
                });
            });
            return result;
        },
        //#!#END
        //#!#START STREETVIEW
        /**
         * Switch StreetView
         * @param {Object} map Map instance
         * @param {Object} opt Options
         */
        streetView: function (map, opt) {

            var self = this,
                opts = opt.hasOwnProperty('streetViewObj') ? opt.streetViewObj : {},
                pano = {},
                loc  = {};

            if ('function' === typeof map.getStreetView) {
                // Default position of streetView
                if (opts.hasOwnProperty('position')) {
                    loc = parseLatLng(opts.position, true);
                    opts.position = 'object' === typeof loc ? map.getCenter() : loc;
                } else {
                    opts.position = map.getCenter();
                }
                // Pov configure
                if (opts.hasOwnProperty('pov')) {
                    opts.pov = $.extend({}, {
                        'heading': 0,
                        'pitch'  : 0,
                        'zoom'   : 1
                    }, opts.pov);
                }
                pano = map.getStreetView();
                // Apply options
                pano.setOptions(opts);

                // Events Binding
                if (opts.hasOwnProperty('event')) {
                    self.bindEvents(pano, opts.event);
                }
                if (opts.hasOwnProperty('visible')) {
                    pano.setVisible(opts.visible);
                }
            }
        },
        //#!#END
        //#!#START PLACES
        /**
         * Places API
         * @param {Object} map Map instance
         * @param {Object} opt Options
         */
        places: function (map, opt) {

            var self = this,
                placesService = {},
                reqOpt = opt.hasOwnProperty('places') ? opt.places : {},
                request = $.extend({
                    'location': map.getCenter(),
                    'radius'  : 100
                }, reqOpt);

            request.location = parseLatLng(request.location, true);

            if ('undefined' !== typeof google.maps.places) {
                placesService = new google.maps.places.PlacesService(map);
                placesService.nearbySearch(request, function (results, status) {
                    if (status === google.maps.places.PlacesServiceStatus.OK) {
                        self._places.push(results);
                        if (request.hasOwnProperty('createMarker') && true === request.createMarker) {
                            results.forEach(function (r) {
                                if (r.hasOwnProperty('geometry')) {
                                    var AM_marker = new google.maps.Marker({
                                        'map': map,
                                        'position': r.geometry.location
                                    })
                                    alert("CCCC : " + AM_marker);
                                    self._markers.push(AM_marker);
                                }
                            });
                        }
                        if (request.hasOwnProperty('callback') && 'function' === typeof request.callback) {
                            request.callback.call(results);
                        }
                    }
                });
            }
        },
        //#!#END
        /**
         * Use HTML5 Geolocation API to detect the client's location.
         * @param {Object} map Map intance
         * @param {Object} opt Plugin options
         */
        geoLocation: function (map, opt) {

            try {

                var self        = this,
                    geoOpt      = {},
                    geolocation = navigator.geolocation;

                if (!geolocation) {
                    return;
                }
                if (opt.hasOwnProperty('geolocation')) {
                    geoOpt = $.extend({}, {
                        'maximumAge'        : 600000,
                        'timeout'           : 3000,
                        'enableHighAccuracy': false
                    }, opt.geolocation);
                }

                if (true === opt.autoLocation || 'function' === typeof opt.autoLocation) {
                    geolocation.watchPosition(
                        function (loc) {
                            if (('undefined' !== typeof loc) &&
                                ('coords' in loc) &&
                                ('latitude' in loc.coords) &&
                                ('longitude' in loc.coords)
                            ) {
                                map.panTo(new google.maps.LatLng(
                                    loc.coords.latitude,
                                    loc.coords.longitude
                                ));
                                if ('function' === typeof opt.autoLocation) {
                                    opt.autoLocation.call(self, loc);
                                }
                            }
                        },
                        function (error) {
                            console.error(error);
                        },
                        geoOpt
                    );
                }
            } catch (ignore) {
            }
        },
        //#!#START PANTO
        /**
         * Method: Google Maps PanTo
         * @param {(string|string[]|number[]|Object)} addr Location
         */
        panTo: function (addr) {

            var m        = this.map,
                loc      = {},
                geocoder = {};

            if (null !== m && 'undefined' !== typeof m) {
                loc = parseLatLng(addr, true);
                if ('string' === typeof loc) {
                    geocoder = new google.maps.Geocoder();
                    geocoder.geocode({'address': loc}, function (results, status) {
                        if (status === google.maps.GeocoderStatus.OK &&
                            'function' === typeof m.panTo &&
                            Array.isArray(results) &&
                            results.length
                        ) {
                            if (results[0].hasOwnProperty('geometry')) {
                                m.panTo(results[0].geometry.location);
                            }
                        } else {
                            console.error(status);
                        }
                    });
                } else {
                    if ('function' === typeof m.panTo) {
                        m.panTo(loc);
                    }
                }
            }
            return $(this.container);
        },
        //#!#END
        //#!#START CLOSE
        /**
         * Method: Close all of infoWindows on map
         * @param {string} type Layer type
         */
        close: function (layer, callback) {
            var self   = this,
                layers = self.get(layer),
                loop   = {},
                obj    = '';

            if (layers.hasOwnProperty('map')) {
                delete layers.map;
            }

            if (Array.isArray(layers)) {
                loop[layer] = layers;
            } else {
                loop = layers;
            }

            try {
                for (obj in loop) {
                    if (Array.isArray(loop[obj])) {
                        loop[obj].forEach(function (item) {
                            if (item.hasOwnProperty('infoWindow') &&
                                'function' === typeof item.infoWindow.close
                            ) {
                                item.infoWindow.close();
                            }
                        });
                    }
                }
                if ('function' === typeof callback) {
                    callback.call(this);
                }
            } catch (ignore) {
                console.warn(ignore);
            } finally {
                return $(self.container);
            }
        },
        //#!#END
        //#!#START CLEAR
        /**
         * Method: Google Maps clear the specificed layer
         * @param {string} type Layer's type
         */
        clear: function (layer, callback) {

            var self     = this,
                dMarkers = self._directionsMarkers,
                layers   = self.get(layer),
                loop     = {},
                key      = '',
                obj      = '';

            if ('undefined' !== typeof layers &&
                'undefined' !== typeof layers.map
            ) {
                    delete layers.map;
            }

            if (Array.isArray(layers)) {
                loop[layer] = layers;
            } else {
                loop = layers;
            }

            function dMarkersLoopCallback (dm, j) {
                if ('function' === typeof dm.setMap) {
                    self._directionsMarkers[j].setMap(null);
                }
            }

            function loopObjCallback (item) {
                // Remove the direction icons.
                if ('direction' === obj) {
                    dMarkers.forEach(dMarkersLoopCallback);
                    self._directionsMarkers.filter(function (n) {
                        return 'undefined' !== typeof n;
                    });
                }
                // Remove from Map
                if ('function' === typeof item.set) {
                    item.set('visible', false);
                }
                if ('function' === typeof item.setMap) {
                    item.setMap(null);
                }
                // Remove from Array
                if (-1 !== self[key].indexOf(item)) {
                    delete self[key][self[key].indexOf(item)];

                }
            }

            function keyFilter (n) {
                return 'undefined' !== typeof n;
            }

            try {
                for (obj in loop) {
                    if (Array.isArray(loop[obj])) {
                        key = '_' + obj.toString().toLowerCase() + 's';
                        loop[obj].forEach(loopObjCallback);
                        // Filter undefined elements
                        self[key] = self[key].filter(keyFilter);
                    }
                }
                if ('function' === typeof callback) {
                    callback.call(this);
                }
            } catch (ignore) {
                console.warn(ignore);
            } finally {
                return $(self.container);
            }
        },
        //#!#END
        //#!#START GET
        /**
         * Method: Google Maps get the specificed layer
         * @param {string} type Layer type
         */
        get: function (layer, callback) {

            var self     = this,
                layers   = [],
                target   = {},
                obj      = {},
                key      = '',
                lb       = '',
                i        = 0;

            if ('undefined' === typeof layer) {
                layer = {
                    'marker'   : [],
                    'label'    : [],
                    'polygon'  : [],
                    'polyline' : [],
                    'circle'   : [],
                    'direction': [],
                    'kml'      : [],
                    'cluster'  : [], // @since 3.2.10
                    'bound'    : []  // @since 3.2.10
                };
            }

            function keyLoopCallback (item) {
                var index = self[key].indexOf(item);
                if (0 === layer[obj].length ||
                    -1 !== layer[obj].indexOf(index)  ||
                    ('undefined' !== typeof item.id && 0 < item.id.length && (-1 !== item.id.indexOf(layer[obj])))
                ) {
                    target[obj].push(item);
                }
            }

            try {
                if ('string' === typeof layer) {
                    if (-1 !== layer.indexOf(',')) {
                        layers = layer.replace(/\s/gi, '').split(',');
                        for (i = 0; i < layers.length; i += 1) {
                            lb = layers[i].toString().toLowerCase();
                            if ('map' === lb) {
                                target[lb] = self.map;
                            } else {
                                key = '_' + lb + 's';
                                target[lb] = self[key];
                            }
                        }
                    } else {
                        if ('map' === layer.toString().toLowerCase()) {
                            target = self.map;
                        } else {
                            key = '_' + layer.toString().toLowerCase() + 's';
                            target = self[key];
                        }
                    }
                } else {
                    for (obj in layer) {
                        if (Array.isArray(layer[obj])) {
                            key = '_' + obj.toString().toLowerCase() + 's';
                            if (Array.isArray(self[key])) {
                                target[obj] = [];
                                self[key].forEach(keyLoopCallback);
                            }
                        }
                    }
                    target.map = self.map;
                }
                if ('function' === typeof callback) {
                    callback.call(this, target);
                }
                return target;
            } catch (ignore) {
                console.error(ignore);
            } finally {
                return target;
            }
        },
        //#!#END
        //#!#START MODIFY
        /**
         * Method:  Google Maps dynamic add layers
         * @param {Object} options Refernce by tinyMap options
         */
        modify: function (options) {

            var self  = this,
                func  = [],
                label = [
                    ['kml', 'kml'],
                    ['marker', 'placeMarkers'],
                    ['direction', 'directionService'],
                    ['polyline', 'drawPolyline'],
                    ['polygon', 'drawPolygon'],
                    ['circle', 'drawCircle'],
                    ['streetView', 'streetView'],
                    ['markerFitBounds', 'markerFitBounds'],
                    ['places', 'places']
                ],
                i = 0,
                m = self.map;

            if ('undefined' !== typeof options) {
                for (i = 0; i < label.length; i += 1) {
                    if (options.hasOwnProperty(label[i][0])) {
                        func.push(label[i][1]);
                    }
                }
                if (null !== m) {
                    if (func.length) {
                        for (i = 0; i < func.length; i += 1) {
                            if ('function' === typeof self[func[i]]) {
                                if ('streetView' === func[i]) {
                                    options.streetViewObj = options.streetView;
                                    delete options.streetView;
                                }
                                self[func[i]](m, options, 'modify');
                            }
                        }
                    } else {
                        m.setOptions(options);
                    }
                    if (options.hasOwnProperty('event')) {
                        self.bindEvents(m, options.event);
                    }
                    google.maps.event.trigger(m, 'resize');
                }
            }
            return $(this.container);
        },
        //#!#END
        //#!#QUERY
        /**
         * Method: Query address or latlng
         * @param {(string|Array|Object)} addr Address or latlng
         * @param {Function} callback Function callback
         */
        query: function (addr, callback) {
            var self = this,
                geocoder = new google.maps.Geocoder(),
                address = parseLatLng(addr),
                opt = {};
            if ('string' === typeof address) {
                opt.address = address;
            } else {
                opt = {
                    'location': {
                        'lat': parseFloat(address.lat, 10),
                        'lng': parseFloat(address.lng, 10)
                    }
                };
            }
            geocoder.geocode(opt, function (results, status) {
                try {
                    if (status === google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
                        setTimeout(function () {
                            self.query(addr, callback);
                        }, self.interval);
                    } else if (status === google.maps.GeocoderStatus.OK && Array.isArray(results)) {
                        if (0 < results.length && results[0].hasOwnProperty('geometry')) {
                            if ('function' === typeof callback) {
                                callback.call(self, results[0]);
                            } else {
                                return results[0];
                            }
                        }
                    } else {
                        console.error('Geocoder Error Code: ' + status);
                    }
                } catch (ignore) {
                    console.error(ignore);
                }
            });
        },
        //#!#END
        //#!#START DESTROY
        destroy: function () {
            var obj = $(this.container);
            if (obj.length) {
                $.removeData(this.container, 'tinyMap');
            }
            return obj.empty();
        },
        //#!#END
        //#!#START GETKML
        getKML: function (opt) {
            var self = this,
                // Options
                opts = $.extend({}, {
                    'marker'   : true,
                    'polyline' : true,
                    'polygon'  : true,
                    'circle'   : true,
                    'direction': true,
                    'download' : false
                }, opt),
                // MIME TYPE of KML
                mime = 'data:application/vnd.google-earth.kml+xml;charset=utf-8;base64,',
                // KML template
                templates = {
                    'xml': [
                        '<?xml version="1.0" encoding="UTF-8"?>',
                        '<kml xmlns="http://earth.google.com/kml/2.2">',
                        '<Document>',
                        '<name><![CDATA[jQuery tinyMap Plugin]]></name>',
                        '<description><![CDATA[]]></description>',
                        '<Style id="style1">',
                        '<PolyStyle>',
                        '<color>50F05A14</color>',
                        '<colorMode>normal</colorMode>',
                        '<fill>1</fill>',
                        '<outline>1</outline>',
                        '</PolyStyle>',
                        '<IconStyle>',
                        '<Icon>',
                        '<href>https://maps.google.com/mapfiles/kml/paddle/grn-circle_maps.png</href>',
                        '</Icon>',
                        '</IconStyle>',
                        '</Style>',
                        '#PLACEMARKS#',
                        '</Document>',
                        '</kml>'
                    ],
                    'placemark': [
                        '<Placemark>',
                        '<name><![CDATA[#NAME#]]></name>',
                        '<Snippet></Snippet>',
                        '<description><![CDATA[]]></description>',
                        '<styleUrl>#style1</styleUrl>',
                        '<ExtendedData></ExtendedData>',
                        '#DATA#',
                        '</Placemark>'
                    ],
                    'polygon': [
                        '<Placemark>',
                        '<styleUrl>#style1</styleUrl>',
                        '<name><![CDATA[#NAME#]]></name>',
                        '<Polygon>',
                        '<tessellate>1</tessellate>',
                        '<extrude>1</extrude>',
                        '<altitudeMode>clampedToGround</altitudeMode>',
                        '<outerBoundaryIs>',
                        '<LinearRing>',
                        '<coordinates>#LATLNG#</coordinates>',
                        '</LinearRing>',
                        '</outerBoundaryIs>',
                        '</Polygon>',
                        '</Placemark>'
                    ],
                    'linestring': '<LineString><tessellate>1</tessellate><coordinates>#LATLNG#</coordinates></LineString>',
                    'point': '<Point><coordinates>#LATLNG#,0.000000</coordinates></Point>'
                },
                strMarker    = '',
                strPolyline  = '',
                strPolygon   = '',
                strCircle    = '',
                strDirection = '',
                output = '';

            // Refactoring
            // @since v3.3
            self.get('marker,polyline,polygon,circle,direction', function (ms) {
                var latlng = '';
                // Marker
                if (true === opts.marker && 'undefined' !== typeof ms.marker) {
                    ms.marker.forEach(function (marker) {
                        latlng = [marker.getPosition().lng(), marker.getPosition().lat()].join(',');
                        strMarker += templates.placemark.join('')
                                              .replace(/#NAME#/gi, 'Markers')
                                              .replace(
                                                  /#DATA#/gi,
                                                  templates.point.replace(/#LATLNG#/gi, latlng)
                                              );
                    });
                }
                // Polyline
                if (true === opts.polyline && 'undefined' !== typeof ms.polyline) {
                    ms.polyline.forEach(function (polyline) {
                        latlng = '';
                        polyline.getPath().getArray().forEach(function (k) {
                            latlng += [k.lng(), k.lat(), '0.000000\n'].join(',');
                        });
                        strPolyline += templates.placemark.join('')
                                                .replace(/#NAME#/gi, 'Polylines')
                                                .replace(
                                                    /#DATA#/gi,
                                                    templates.linestring.replace(/#LATLNG#/gi, latlng)
                                                );
                    });
                }
                // Polygon
                if (true === opts.polygon && 'undefined' !== typeof ms.polygon) {
                    ms.polygon.forEach(function (polygon) {
                        latlng = '';
                        polygon.getPath().getArray().forEach(function (k) {
                            latlng += [k.lng(), k.lat(), '0.000000\n'].join(',');
                        });
                        strPolygon += templates.polygon.join('')
                                               .replace(/#NAME#/gi, 'Polygons')
                                               .replace(/#LATLNG#/gi, latlng);
                    });
                }
                // Circle
                if (true === opts.circle && 'undefined' !== typeof ms.circle) {
                    ms.circle.forEach(function (circle) {
                        latlng = '';
                        var d2r = Math.PI / 180,
                            r2d = 180 / Math.PI,
                            earthsradius = 6378137,
                            points = 64,
                            rlat = (circle.getRadius() / earthsradius) * r2d,
                            rlng = rlat / Math.cos(circle.getCenter().lat() * d2r),
                            theta = 0,
                            ey = 0,
                            ex = 0,
                            j = 0;
                        for (j = 0; j < 65; j += 1) {
                            theta = Math.PI * (j / (points/2));
                            ey = circle.getCenter().lng() + (rlng * Math.cos(theta));
                            ex = circle.getCenter().lat() + (rlat * Math.sin(theta));
                            latlng += [ey, ex, '0.000000\n'].join(',');
                        }
                        strCircle += templates.polygon.join('')
                                              .replace(/#NAME#/gi, 'Circles')
                                              .replace(/#LATLNG#/gi, latlng);
                    });
                }
                // Direction
                if (true === opts.direction && 'undefined' !== typeof ms.direction) {
                    ms.direction.forEach(function (direction) {
                        var d = direction.getDirections();
                        if (
                            d.hasOwnProperty('routes') &&
                            Array.isArray(d.routes) &&
                            'undefined' !== typeof d.routes[0] &&
                            'undefined' !== typeof d.routes[0].legs &&
                            Array.isArray(d.routes[0].legs)
                        ) {
                            d.routes[0].legs.forEach(function (leg) {
                                if (Array.isArray(leg.steps)) {
                                    leg.steps.forEach(function (step) {
                                        latlng = '';
                                        if (Array.isArray(step.path)) {
                                            step.path.forEach(function (path) {
                                                latlng += [path.lng(), path.lat(), '0.000000\n'].join(',');
                                            });
                                        }
                                        strDirection += templates.placemark.join('')
                                                                 .replace(/#NAME#/gi, 'Directions')
                                                                 .replace(
                                                                     /#DATA#/gi,
                                                                     templates.linestring.replace(/#LATLNG#/gi, latlng)
                                                                 );
                                    });
                                }
                            });
                        }
                    });
                }
            });
            // Output KML
            output = templates.xml.join('')
                              .replace(/#NAME#/gi, '')
                              .replace(
                                  /#PLACEMARKS#/gi,
                                  strMarker +
                                  strPolyline +
                                  strPolygon +
                                  strCircle +
                                  strDirection
                              );
            if (true === opts.download) {
                window.open(mime + window.btoa(window.decodeURIComponent(window.encodeURIComponent(output))));
            } else {
                return output;
            }
        },
        //#!#END
        /**
         * tinyMap initialize
         */
        init: function Initialize () {

            var self     = this,
                script   = {},
                geocoder = {},
                param    = $.extend({}, tinyMapConfigure),
                api      = param.api.split('?')[0],
                msg      = '',
                vo       = {},
                o        = {},
                defIdle  = true,
                se;

            try {
                delete param.api;
                delete param.clusterer;
                delete param.withLabel;
                param = $.param(param);
            } catch (ignore) {
            }

            // Asynchronous loading Google Maps API
            if (!apiLoaded && 'undefined' === typeof window.google) {
                script = document.createElement('script');
                script.setAttribute('src', [api, param].join('?'));
                (document.getElementsByTagName('head')[0] || document.documentElement).appendChild(script);
                apiLoaded = true;
                script = null;
            }

            // Make sure Google maps API is loaded.
            if ('object' === typeof window.google) {

                scan(self.options);

                // Load MarkerClusterer library
                if (!apiClusterLoaded &&
                    self.options.hasOwnProperty('markerCluster') &&
                    false !== self.options.markerCluster &&
                    'undefined' === typeof MarkerClusterer
                ) {
                    script = document.createElement('script');
                    script.setAttribute('src', tinyMapConfigure.clusterer);
                    (document.getElementsByTagName('head')[0] || document.documentElement).appendChild(script);
                    apiClusterLoaded = true;
                    script = null;
                }


                // Load MarkerWithLabel library
                if (!apiMarkerWithLabelLoaded &&
                    self.options.hasOwnProperty('markerWithLabel') &&
                    true === self.options.markerWithLabel &&
                    'undefined' === typeof MarkerWithLabel
                ) {
                    script = document.createElement('script');
                    script.setAttribute('src', tinyMapConfigure.withLabel);
                    (document.getElementsByTagName('head')[0] || document.documentElement).appendChild(script);
                    apiMarkerWithLabelLoaded = true;
                    script = null;
                }

                // Load OMS library
                if (!apiOMSLoaded &&
                    self.options.hasOwnProperty('enableOMS') &&
                    'undefined' === typeof OverlappingMarkerSpiderfier
                ) {
                    script = document.createElement('script');
                    script.setAttribute('src', tinyMapConfigure.OMS);
                    (document.getElementsByTagName('head')[0] || document.documentElement).appendChild(script);
                    apiOMSLoaded = true;
                    script = null;
                }

                self._bounds = new google.maps.LatLngBounds();
                //#!#START LABEL
                Label.prototype = new google.maps.OverlayView();
                Label.prototype.onAdd = function () {
                    var self = this;
                    if (null !== self.div) {
                        self.div.appendTo($(self.getPanes().overlayLayer));
                        self.listeners = [
                            google.maps.event.addListener(self, 'visible_changed', function () { self.draw(); }),
                            google.maps.event.addListener(self, 'position_changed', function () { self.draw(); }),
                            google.maps.event.addListener(self, 'visible_changed', function () { self.draw(); }),
                            google.maps.event.addListener(self, 'clickable_changed', function () { self.draw(); }),
                            google.maps.event.addListener(self, 'text_changed', function () { self.draw(); }),
                            google.maps.event.addListener(self, 'zindex_changed', function () { self.draw(); })
                        ];
                    }
                };
                Label.prototype.draw = function () {
                    var self = this,
                        projection = self.getProjection(),
                        position   = {};
                    try {
                        if (null !== self.div) {
                            if (projection) {
                                position = projection.fromLatLngToDivPixel(self.get('position'));
                                if (position) {
                                    self.div.css({
                                        'left'    : position.x + 'px',
                                        'top'     : position.y + 'px',
                                        'display' : self.get('visible') ? 'block' : 'none'
                                    });
                                }
                                if (self.text) {
                                    self.span.html(self.text.toString());
                                }
                            }
                        }
                    } catch (ignore) {
                        console.error(ignore);
                    }
                };
                Label.prototype.onRemove = function () {
                    $(this.div).remove();
                    this.div = null;
                };
                //#!#END
                // Parsing ControlOptions
                for (o in self.options) {
                    if (self.options.hasOwnProperty(o)) {
                        vo = self.options[o];
                        if (/ControlOptions/g.test(o) &&
                            vo.hasOwnProperty('position') &&
                            'string' === typeof vo.position
                        ) {
                            self.options[o].position = google.maps.ControlPosition[vo.position.toUpperCase()];
                        }
                    }
                }

                // Merge options
                self.googleMapOptions = self.options;

                // Process streetView conflict
                if (self.options.hasOwnProperty('streetView')) {
                    self.googleMapOptions.streetViewObj = self.options.streetView;
                    delete self.googleMapOptions.streetView;
                }

                // Center location parse
                self.googleMapOptions.center = parseLatLng(self.options.center, true);

                //#!#START STYLES
                // Map styles apply
                if (self.options.hasOwnProperty('styles')) {
                    if ('string' === typeof self.options.styles &&
                        styles.hasOwnProperty(self.options.styles)
                    ) {
                        self.googleMapOptions.styles = styles[self.options.styles];
                    } else if (Array.isArray(self.options.styles)) {
                        self.googleMapOptions.styles = self.options.styles;
                    }
                }
                //#!#END
                if ('string' === typeof self.options.center) {
                    geocoder = new google.maps.Geocoder();
                    geocoder.geocode({'address': self.options.center}, function (results, status) {
                        try {
                            if (status === google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
                                setTimeout(function () {
                                    self.init();
                                }, self.interval);
                            } else if (status === google.maps.GeocoderStatus.OK && Array.isArray(results)) {
                                if (0 < results.length && results[0].hasOwnProperty('geometry')) {
                                    self.googleMapOptions.center = results[0].geometry.location;
                                    self.map = new google.maps.Map(self.container, self.googleMapOptions);
                                    // Function injection for IDLE event.
                                    // @since 3.4.0
                                    se = 'undefined' !== typeof self.options.event ? self.options.event : {};
                                    self.mapIdleEvent(se);
                                }
                            } else {
                                msg = (self.options.notFound || status).toString();
                                self.container.innerHTML = $('<div/>').text(msg).html();
                                console.error('Geocoder Error Code: ' + status);
                            }
                        } catch (ignore) {
                            console.error(ignore);
                        }
                    });
                } else {
                    self.map = new google.maps.Map(self.container, self.googleMapOptions);
                    // Function injection for IDLE event.
                    // @since 3.4.0
                    se = 'undefined' !== typeof self.options.event ? self.options.event : {};
                    self.mapIdleEvent(se);
                }
            }
        },
        /**
         * Process custom events of Map to prevent conflict.
         *
         * @param {Object} se Options
         * @since 3.4.0
         */
        mapIdleEvent: function (se) {
            var self = this;
            if (se.hasOwnProperty('idle')) {
                if ('undefined' !== se.idle.func &&
                    'function' === typeof se.idle.func &&
                    'undefined' !== typeof se.idle.once
                ) {
                    if (true === se.idle.once) {
                        google.maps.event.addListenerOnce(self.map, 'idle', function () {
                            self.overlay();
                            se.idle.func.apply(this, arguments);
                            delete se.idle;
                            self.bindEvents(self.map, se);
                        });
                    } else {
                        google.maps.event.addListener(self.map, 'idle', function () {
                            self.overlay();
                            se.idle.func.apply(this, arguments);
                            self.bindEvents(self.map, se);
                        });
                    }
                } else {
                    if ('function' === typeof se.idle) {
                        google.maps.event.addListener(self.map, 'idle', function () {
                            self.overlay();
                            se.idle.apply(this, arguments);
                            self.bindEvents(self.map, se);
                        });
                    }
                }
            } else {
                google.maps.event.addListenerOnce(self.map, 'idle', function () {
                    self.overlay();
                    self.bindEvents(self.map, se);
                });
            }
        }
    };
    /**
     * jQuery tinyMap API configure
     * @param {Object} options Plugin configure
     * @global
     */
    $.fn.tinyMapConfigure = function (options) {
        tinyMapConfigure = $.extend(tinyMapConfigure, options);
    };
    /**
     * jQuery tinyMap instance
     * @param {Object} options Plugin settings
     * @public
     */
    $.fn.tinyMap = function (options) {
        var instance = {},
            result   = [],
            args     = arguments,
            id       = 'tinyMap';
        if ('string' === typeof options) {
            this.each(function () {
                instance = $.data(this, id);
                if (instance instanceof TinyMap && 'function' === typeof instance[options]) {
                    result = instance[options].apply(instance, Array.prototype.slice.call(args, 1));
                }
            });
            return 'undefined' !== typeof result ? result : this;
        } else {
            return this.each(function () {
                if (!$.data(this, id)) {
                    $.data(this, id, new TinyMap(this, options));
                }
            });
        }
    };
})(window.jQuery || {}, window, document);
//#EOF
</script>