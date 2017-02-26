       /**
         * Post process of Marker
         * @since v3.3.0
         * @param {Object} map Map instance
         * @param {Object} opt jQ tinyMap Options
         * @param {Object} marker Marker object
         * @param {Object} m Marker option
         */
        processMarker: function (mc, map, opt, marker, source) {

            var self     = this,
                exists   = self.get('marker'),
                label    = {},
                labelOpt = {},
                infoOpt  = {},
                oms      = {};

            // Apply marker fitbounds
            if (marker.hasOwnProperty('position')) {
                if ('function' === typeof marker.getPosition) {
                    self._bounds.extend(marker.position);
                }
                if (opt.hasOwnProperty('markerFitBounds') &&
                    true === opt.markerFitBounds
                ) {
                    // Make sure fitBounds call after the last marker created.
                    if (exists.length === opt.marker.length) {
                        map.fitBounds(self._bounds);
                    }
                }
            }

            // InfoWindow
            if ('undefined' === typeof marker.infoWindow) {
                //====暐翰====
                marker.infoWindow = new google.maps.InfoWindow({
                    'content': marker.text
                });
            }

            if (marker.hasOwnProperty('text')) {

                marker.infoWindow.setContent(marker.text);

                if (!marker.hasOwnProperty('event') ||
                    !marker.event.hasOwnProperty('click')
                ) {
                    marker.defaultInfoWindow = true;
                }

                self.bindEvents(marker, marker.event);

                // @since 3.3.16
                if (marker.hasOwnProperty('infoWindowOptions')) {
                    infoOpt = $.extend({}, {
                        'content': marker.infoWindowOptions.hasOwnProperty('content') ?
                                   marker.infoWindowOptions.content :
                                   marker.text
                    }, marker.infoWindowOptions);
                    marker.infoWindow.setOptions(infoOpt);
                    // infoWindow events binding.
                    if (infoOpt.hasOwnProperty('event') && 'undefined' !== typeof infoOpt.event) {
                        self.bindEvents(marker.infoWindow, infoOpt.event);
                    }
                }
            }
            /**
             * Apply marker cluster.
             * Require markerclusterer.js
             * Only affect in INSERT mode.
             * @see {@link http://google-maps-utility-library-v3.googlecode.com/svn/trunk/markerclusterer/src/}
             * @since 2015-10-01 18:20:00
             */
            if (!source) {
                // Markers cluster
                if (!marker.hasOwnProperty('cluster') ||
                    (marker.hasOwnProperty('cluster') && true === marker.cluster)
                ) {
                    if ('function' === typeof self._clusters.addMarker) {
                        self._clusters.addMarker(marker);
                    }
                }
            }

            // Create Label
            if ((opt.hasOwnProperty('markerWithLabel') && true === opt.markerWithLabel) &&
                marker.hasOwnProperty('newLabel')
            ) {
                labelOpt = {
                    'id'  : marker.id,
                    'text': marker.newLabel,
                    'map' : map,
                    'css' : marker.hasOwnProperty('newLabelCSS') ?
                            marker.newLabelCSS.toString() :
                            ''
                };

                self.get({
                    'label': [marker.id]
                }, function (ms) {
                    // Modify existed label if exists.
                    var i   = 0,
                        len = ms.label.length,
                        lb = {};
                    if (len) {
                        /*
                        for (i = 0; i < len; i += 1) {
                            lb = ms.label[i];
                            lb.text = marker.newLabel;
                            $(lb.span).addClass(marker.newLabelCSS);
                            lb.bindTo('position', marker);
                            lb.draw();
                        }
                        */
                        ms.label.forEach(function (lb) {
                            lb.text = marker.newLabel;
                            $(lb.span).addClass(marker.newLabelCSS);
                            lb.bindTo('position', marker);
                            lb.draw();
                        });

                    // Or create the new one.
                    // @since v3.3.6

                    } else {
                        label = new Label(labelOpt);
                        label.bindTo('position', marker);
                        self._labels.push(label);
                        // @since 3.3.15
                        label.set('visible', marker.showLabel);
                        // Hide or show labels when clustering end.
                        // @since v3.3.11
                        if ('object' === typeof label && true === opt.markerCluster) {
                            google.maps.event.addListener(marker, 'map_changed', function () {
                                if ('function' === typeof label.setMap) {
                                    label.set('visible', null !== marker.getMap());
                                }
                            });
                        }
                    }
                });

            }
            // Binding events
            self.bindEvents(marker, marker.event);
        }