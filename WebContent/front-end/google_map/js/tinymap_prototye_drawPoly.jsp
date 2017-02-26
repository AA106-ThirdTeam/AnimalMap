      //begin add Multiple POLYLINE by Karry
      /**
       * Polyline overlay
       * @param {Object} map Map instance
       * @param {Object} opt Polyline options
       */
      drawPolyline: function (map, opt) {
          var self = this,
              polylineX = {},
              waypoints = [],
              polyline = {},
              distance = {},
              service = {},
              defOpt = {},
              coords = [],
              path = [],
              c1 = 0,
              c = {},
              p = {},
              i = 0,
              // Route callback
              routeCallback = function (result, status) {
                  if (status === google.maps.DirectionsStatus.OK) {
                      for (i = 0; i < result.routes[0].overview_path.length; i += 1) {
                          path.push(result.routes[0].overview_path[i]);
                      }
                      polyline.setPath(path);
                      if ('function' === typeof polylineX.getDistance) {
                          distance = result.routes[0].legs[0].distance;
                          polylineX.getDistance.call(this, distance);
                      }
                  }
              };

          if (opt.hasOwnProperty('polyline') && Array.isArray(opt.polyline)) {
              for (c1 = 0; c1 < opt.polyline.length; c1 += 1) {
                  polylineX = opt.polyline[c1];
                  if (polylineX.hasOwnProperty('coords') &&
                      Array.isArray(polylineX.coords)
                  ) {
                      coords = new google.maps.MVCArray();
                      for (i = 0; i < polylineX.coords.length; i += 1) {
                          p = polylineX.coords[i];
                          c = parseLatLng(p, true);
                          if ('function' === typeof c.lat) {
                              coords.push(c);
                          }
                      }
                      // Options merge
                      defOpt = $.extend({}, {
                          'strokeColor'  : polylineX.color || '#FF0000',
                          'strokeOpacity': polylineX.opacity || 1.0,
                          'strokeWeight' : polylineX.width || 2
                      }, polylineX);

                      polyline = new google.maps.Polyline(defOpt);
                      self._polylines.push(polyline);

                      if (2 < coords.getLength()) {
                          for (i = 0; i < coords.length; i += 1) {
                              if (0 < i && (coords.length - 1 > i)) {
                                  waypoints.push({
                                      'location': coords.getAt(i),
                                      'stopover': false
                                  });
                              }
                          }
                      }

                      // Events binding
                      if (polylineX.hasOwnProperty('event')) {
                          self.bindEvents(polyline, polylineX.event);
                      }

                      if (polylineX.hasOwnProperty('snap') &&
                          true === polylineX.snap
                      ) {
                          service = new google.maps.DirectionsService();
                          service.route({
                              'origin': coords.getAt(0),
                              'waypoints': waypoints,
                              'destination': coords.getAt(coords.length - 1),
                              'travelMode': google.maps.DirectionsTravelMode.DRIVING
                          }, routeCallback);
                      } else {
                          polyline.setPath(coords);
                          if (google.maps.hasOwnProperty('geometry') &&
                              google.maps.geometry.hasOwnProperty('spherical')
                          ) {
                              if ('function' === typeof google.maps.geometry.spherical.computeDistanceBetween) {
                                  distance = google.maps
                                                   .geometry
                                                   .spherical
                                                   .computeDistanceBetween(
                                                       coords.getAt(0),
                                                       coords.getAt(coords.length - 1)
                                                   );
                                  if ('function' === typeof polylineX.getDistance) {
                                      polylineX.getDistance.call(self, distance);
                                  }
                              }
                          }
                      }
                      polyline.setMap(map);
                  }
              }
          }
      }
,
      //add Multiple POLYLINE by karry
      //#!#END
      //#!#START POLYGON
      /**
       * Polygon overlay
       * @param {Object} map Map instance
       * @param {Object} opt Polygon options
       */
      drawPolygon: function (map, opt) {

          var self = this,
              polygon = {},
              defOpt = {},
              coords = [],
              i = 0,
              j = 0,
              p = {},
              c = {};

          if (opt.hasOwnProperty('polygon') && Array.isArray(opt.polygon)) {
              for (i = 0; i < opt.polygon.length; i += 1) {
                  coords = [];
                  if (opt.polygon[i].hasOwnProperty('coords')) {
                      for (j = 0; j < opt.polygon[i].coords.length; j += 1) {
                          p = opt.polygon[i].coords[j];
                          c = parseLatLng(p, true);
                          if ('function' === typeof c.lat) {
                              coords.push(c);
                          }
                      }
                      defOpt = $.extend({}, {
                          'path': coords,
                          'strokeColor': opt.polygon[i].color || '#FF0000',
                          'strokeOpacity': 1.0,
                          'strokeWeight': opt.polygon[i].width || 2,
                          'fillColor': opt.polygon[i].fillcolor || '#CC0000',
                          'fillOpacity': 0.35
                      }, opt.polygon[i]);

                      polygon = new google.maps.Polygon(defOpt);
                      self._polygons.push(polygon);
                      polygon.setMap(map);

                      // Created event for circle is created.
                      if (defOpt.hasOwnProperty('event')) {
                          self.bindEvents(polygon, defOpt.event);
                      }
                  }
              }
          }
      },
      //#!#END
      //#!#START CIRCLE
      /**
       * Circle overlay
       * @param {Object} map Map instance
       * @param {Object} opt Circle options
       */
      drawCircle: function (map, opt) {

          var self = this,
              circles = {},
              circle = {},
              defOpt = {},
              loc = {},
              c = 0;

          if (opt.hasOwnProperty('circle') && Array.isArray(opt.circle)) {
              for (c = 0; c < opt.circle.length; c += 1) {
                  circle = opt.circle[c];
                  defOpt = $.extend({
                      'map': map,
                      'strokeColor': circle.color || '#FF0000',
                      'strokeOpacity': circle.opacity || 0.8,
                      'strokeWeight': circle.width || 2,
                      'fillColor': circle.fillcolor || '#FF0000',
                      'fillOpacity': circle.fillopacity || 0.35,
                      'radius': circle.radius || 10,
                      'zIndex': 100,
                      'id' : circle.hasOwnProperty('id') ? circle.id : ''
                  }, circle);
                  if (circle.hasOwnProperty('center')) {
                      loc = parseLatLng(circle.center, true);
                      defOpt.center = loc;
                  }
                  if ('function' === typeof loc.lat) {

                      circles = new google.maps.Circle(defOpt);
                      self._circles.push(circles);

                      if (circle.hasOwnProperty('event')) {
                          self.bindEvents(circles, circle.event);
                      }
                  }
              }
          }
      }        