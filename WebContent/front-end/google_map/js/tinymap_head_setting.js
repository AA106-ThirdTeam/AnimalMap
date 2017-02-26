'use strict';

// API Configure
var apiLoaded = false,
    apiClusterLoaded = false,
    apiMarkerWithLabelLoaded = false,
    apiOMSLoaded = false,
    tinyMapConfigure = {
        'language' : 'zh-TW',
        'callback' : 'gMapsCallback',
        'api'      : 'https://maps.googleapis.com/maps/api/js',
        'clusterer': 'https://cdn.essoduke.org/js/tinyMap/markerclusterer.js',
        'withLabel': 'https://cdn.essoduke.org/js/tinyMap/markerwithlabel.js',
        'OMS'      : 'https://cdn.essoduke.org/js/tinyMap/oms.min.js'
    },
// Default plugin settings
    defaults = {
        'autoLocation': false,
        'center': [24, 121],
        'infoWindowAutoClose': true,
        'interval': 200,
        'loading': '讀取中&hellip;',
        'notFound': '找不到查詢的地點',
        'zoom': 8
    },
    styles = {},
    timeout;
//#!#START STYLES
    styles = {
        // Grey Scale
        'greyscale': [{
            'featureType': 'all',
            'stylers': [
                {'saturation': -100},
                {'gamma': 0.5}
            ]
        }]
    };
//#!#END