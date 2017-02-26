        /**
         * Format to google.maps.Size
         * @param {number[]} size Size array [x, y]
         * @return {(Object|Array)}
         */
        formatSize: function (size) {
            if (Array.isArray(size) && 2 === size.length) {
                return new google.maps.Size(size[0], size[1]);
            }
            return size;
        },
        /**
         * Format to google.maps.Point
         * @param {number[]} point Point array [x, y]
         * @return {(Object|Array)}
         */
        formatPoint: function (point) {
            if (Array.isArray(point) && 2 === point.length) {
                return new google.maps.Point(point[0], point[1]);
            }
            return point;
        }