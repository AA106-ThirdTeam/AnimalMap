        /**
         * Markers HTML Control
         * @since v3.3.8
         */
        markerControl: function () {

            var self = this,
                opt = self.options,
                mOpt = {
                    'css': '',
                    'label': '請選擇&hellip;',
                    'infoWindow': true,
                    'panTo': true,
                    'onChange': ''
                },
                controls;

            if (opt.hasOwnProperty('markerControl')) {

                // Get container of control list.
                if ('string' === typeof opt.markerControl) {
                    controls = $(opt.markerControl.toString());
                } else {
                    if (opt.markerControl.hasOwnProperty('container')) {
                        controls = $(opt.markerControl.container);
                    } else {
                        controls = $(opt.markerControl);
                    }
                    mOpt = $.extend({}, mOpt, opt.markerControl);
                }
                if (controls.length) {
                    self.get('marker', function (ms) {

                        // Select list template
                        var html = [
                            '<select class="marker-list-control">',
                            '<option>' + mOpt.label + '</option>'
                        ];

                        // Build the html
                        ms.forEach(function (m) {
                            if ('undefined' !== typeof m.infoWindow) {
                                m.infoWindow.close();
                            }
                            html.push('<option value="' + m.id + '" data-marker-id="' + m.id + '">' + (m.title ? m.title : m.id) + '</option>');
                        });
                        html.push('</select>');
                        // onChange binding
                        controls.on('change.tinyMap', 'select', function () {
                            var option = $(this);
                            self.close('marker');
                            if (this.value.length) {
                                // Get the marker that has selected.
                                self.get({'marker': [this.value]}, function (g) {
                                    var mk = {};
                                    if (g.marker.length && 'undefined' !== g.marker[0]) {
                                        mk = g.marker[0];
                                        if (true === mOpt.infoWindow) {
                                            if ('undefined' !== typeof mk.infoWindow &&
                                                'function' === typeof mk.infoWindow.open
                                            ) {
                                                mk.infoWindow.open(self.map, mk);
                                            }
                                        }
                                        if (true === mOpt.panTo) {
                                            self.map.panTo(mk.getPosition());
                                        }
                                        if ('function' === typeof mOpt.onChange) {
                                            mOpt.onChange.call(option, mk);
                                        }
                                    }
                                });
                            }
                        })
                        .html(html.join(''));
                        // Add Custom CSS Class
                        if ('string' === typeof mOpt.css) {
                            controls.find('select').addClass(mOpt.css);
                        }
                    });
                }
            }
        }