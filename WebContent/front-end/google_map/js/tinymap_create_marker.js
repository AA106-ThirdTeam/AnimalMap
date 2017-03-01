var mc = markers.length;
// Markers loop
markers.forEach(function (m, index) {

    var addr = parseLatLng(m.addr, true),
        icons = self.markerIcon(m),
        insertFlag = true,
        markerExisted = false,
        marker = {},
        mk = {},
        id = 'undefined' !== typeof m.id ? m.id : (m.addr.toString().replace(/\s/g, '')),
        markerOptions = {
            'id': id,
            'map': map,
            'animation': null,
            'showLabel': true
        };

    markerOptions = $.extend({}, markerOptions, m);

    // For Modify mode.
    if ('modify' === source && id) {
        self.get({
            'marker': [id]
        }, function (ms) {
            // Has found the marker
            if (Array.isArray(ms.marker) && ms.marker.length) {
                if (!(m.hasOwnProperty('forceInsert') && true === m.forceInsert)) {
                    m = $.extend(ms.marker[0], m);
                    if ('function' === typeof self._clusters.removeMarker) {
                        self._clusters.removeMarker(ms.marker[0]);
                    }
                    insertFlag = false;
                    markerExisted = true;
                }
            }
        });
    }

    if (m.hasOwnProperty('title')) {
        markerOptions.title = m.title.toString().replace(/<([^>]+)>/g, '');
    }

    if (!$.isEmptyObject(icons)) {
        markerOptions.icon = icons;
    }

    if (m.hasOwnProperty('animation') && 'string' === typeof m.animation) {
        markerOptions.animation = google.maps.Animation[m.animation.toUpperCase()];
    }

    if ('string' === typeof addr) {
        // For string address
        geocoder = new google.maps.Geocoder();
        geocoder.geocode({'address': addr}, function (results, status) {
            // If exceeded, create later.
            if (status === google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
                // OVER_QUERY_LIMIT redo.
                // @since 3.4.5
                setTimeout(function () {
                    //console.info(['Marker[', index, '] query failed at (', addr, ').'].join(''));
                    self.placeMarkers(mc, map, opt, source, [m]);
                }, self.interval * (index + 1));
            } else if (status === google.maps.GeocoderStatus.OK) {
                if (!insertFlag && markerExisted) {
                    if ('function' === typeof m.setPosition) {
                        m.setPosition(results[0].geometry.location);
                        if (markerOptions.hasOwnProperty('title')) {
                            m.setTitle(markerOptions.title);
                        }
                        if (markerOptions.hasOwnProperty('icon')) {
                            m.setIcon(markerOptions.icon);
                        }
                    }
                    mk = m;
                } else {
                    markerOptions.position = results[0].geometry.location;
                    if (opt.hasOwnProperty('markerWithLabel') && true === opt.markerWithLabel) {
                        marker = 'function' === typeof MarkerWithLabel ?
                                 new MarkerWithLabel(markerOptions) :
                                 new google.maps.Marker(markerOptions);
                    } else {
                        marker = new google.maps.Marker(markerOptions);
                    }
                    //alert("111 : ")
                    self._markers.push(marker);
                    mk = marker;
                }
                if (hasOMS) {
                    oms.addMarker(mk);
                }
                // Post process of marker
                // @since v3.3.0
                self.processMarker(mc, map, opt, mk, source);
            }
        });
    } else {
        // For LatLng type
        // When Marker was existed.
        if (!insertFlag && markerExisted) {
            if ('function' === typeof m.setPosition) {
                if (addr.lat() && addr.lng()) {
                    m.setPosition(addr);
                }
            }
            if (markerOptions.hasOwnProperty('title')) {
                m.setTitle(markerOptions.title);
            }
            if (markerOptions.hasOwnProperty('icon')) {
                m.setIcon(markerOptions.icon);
            }
            mk = m;
        } else {
            markerOptions.position = addr;
            if (opt.hasOwnProperty('markerWithLabel') && true === opt.markerWithLabel) {
                marker = 'function' === typeof MarkerWithLabel ?
                         new MarkerWithLabel(markerOptions) :
                         new google.maps.Marker(markerOptions);
            } else {
                marker = new google.maps.Marker(markerOptions);
            }

            //AM_lastest_marker = marker;
            //
            // ==== 動物地圖修改 ====
           
            
            if (marker.id != null || marker.id.length>0) {
                //console.log(marker.id);
                AM_markers.set(marker.id, marker);
            }
            //console.log(marker.id);
            if (marker.id.toString().indexOf("AM_autoLocation")>-1) {
                //alert(marker.getPosition())
                            map.panTo(marker.getPosition());
                            native_map.panBy(overlayWidth, overlayHeight);
                        }
  
                        self._markers.push(marker);
                        mk = marker;
                        if (hasOMS) {
                            oms.addMarker(mk);
                        }
                    }
                    // Post process of marker
        // @since v3.3.0
        self.processMarker(mc, map, opt, mk, source);
    }
});