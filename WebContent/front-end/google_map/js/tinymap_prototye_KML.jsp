//#!#START KML
/**
 * KML overlay
 * @param {Object} map Map instance
 * @param {Object} opt KML options
 */
kml: function (map, opt) {

    var self = this,
        kmlOpt = {
            'url': '',
            'map': map,
            'preserveViewport': false,
            'suppressInfoWindows': false
        },
        kml = {},
        i = 0;

    if (opt.hasOwnProperty('kml')) {
        if ('string' === typeof opt.kml) {
            kmlOpt.url = opt.kml;
            kml = new google.maps.KmlLayer(kmlOpt);
            this._kmls.push(kml);
        } else if (Array.isArray(opt.kml)) {
            for (i = 0; i < opt.kml.length; i += 1) {
                if ('string' === typeof opt.kml[i]) {
                    kmlOpt.url = opt.kml[i];
                    kml = new google.maps.KmlLayer(kmlOpt);
                } else if ('object' === typeof opt.kml[i]) {
                    kmlOpt = $.extend({}, kmlOpt, opt.kml[i]);
                    kml = new google.maps.KmlLayer(kmlOpt);
                    if (kmlOpt.hasOwnProperty('event')) {
                        self.bindEvents(kml, kmlOpt.event);
                    }
                }
                this._kmls.push(kml);
            }
        }
    }
}
//#!#END