        /**
         * Build the icon options of marker
         * @param {Object} opt Marker option
         */
        markerIcon: function (marker) {

            var icons = {};

            if (marker.hasOwnProperty('icon')) {

                icons = marker.icon;

                if ('string' === typeof marker.icon) {
                    return marker.icon;
                }

                if (marker.icon.hasOwnProperty('url')) {
                    icons.url = marker.icon.url;
                }
                if (marker.icon.hasOwnProperty('size')) {
                    if (Array.isArray(marker.icon.size) &&
                        2 === marker.icon.size.length
                    ) {
                        icons.size = this.formatSize(marker.icon.size);
                    }
                }
                if (marker.icon.hasOwnProperty('scaledSize')) {
                    if (Array.isArray(marker.icon.scaledSize) &&
                        2 === marker.icon.scaledSize.length
                    ) {
                        icons.scaledSize = this.formatSize(marker.icon.scaledSize);
                    }
                }
                if (marker.icon.hasOwnProperty('anchor')) {
                    if (Array.isArray(marker.icon.anchor) &&
                        2 === marker.icon.anchor.length
                    ) {
                        icons.anchor = this.formatPoint(marker.icon.anchor);
                    }
                }
            }
            return icons;
        }