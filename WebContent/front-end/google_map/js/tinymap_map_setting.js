    /**
     * jQuery tinyMap Constructor
     * @param {Object} container HTML element
     * @param {(Object|string)} options User settings
     */
    function TinyMap (container, options) {

        var self = this,
            opt = $.extend({}, defaults, options);

        /**
         * Overlay loading control
         * @type {bool}
         */
        self.idleOnceCount = false;
        /**
         * Map instance
         * @type {Object}
         */
        self.map = null;
        /**
         * Map markers
         * @type {Object}
         */
        self._markers = [];
        /**
         * Markers
         * @type {Object[]}
         */
        self._markersCluster = [];
        /**
         * Marker clusters
         * @type {Object[]}
         */
        self._clusters = {};
        /**
         * Bounds object
         * @type {Object[]}
         */
        self._bounds = {};
        /**
         * Labels
         * @type {Object[]}
         */
        self._labels = [];
        /**
         * Polyline layers
         * @type {Object[]}
         */
        self._polylines = [];
        /**
         * Polygon layers
         * @type {Object[]}
         */
        self._polygons = [];
        /**
         * Circles layer
         * @type {Object[]}
         */
        self._circles = [];
        /**
         * KML layers
         * @type {Object[]}
         */
        self._kmls = [];
        /**
         * Direction Display layers
         * @type {Objects[]}
         */
        self._directions = [];
        /**
         * Direction icons
         * @type {Object[]}
         */
        self._directionsMarkers = [];
        /**
         * Places objects
         * @type {Object[]}
         */
        self._places = [];
        /**
         * DOM of selector
         * @type {Object}
         */
        self.container = container;
        /**
         * User setting
         * @type {Object}
         */
        self.options = opt;
        /**
         * Google Map options
         * @type {Object}
         */
        self.googleMapOptions = {};
        /**
         * Interval for geocoder's query interval
         * @type {number}
         */
        self.interval = parseInt(self.options.interval, 10) || 200;
        /**
         * Binding callback event for API async
         */
        $(window).on('gMapsCallback', function () {
            self.init();
        });
        // Append loading string
        $(this.container).html(opt.loading);
        // Call initialize
        return self.init();
    }