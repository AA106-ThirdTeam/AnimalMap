/**
 * Events binding
 * @param {Object} marker Marker objects
 * @param {(function|Object)} event Events
 */
bindEvents: function (target, event) {

    var self = this,
        e    = {};
    
    switch (typeof event) {
    case 'function':
        google.maps.event.clearListeners(target, 'click');
        google.maps.event.addListener(target, 'click', event);
        break;
    case 'object':
        for (e in event) {
            if ('function' === typeof event[e]) {
                if ('created' === e) {
                    event[e].call(target);
                } else {
                    google.maps.event.clearListeners(target, e);
                    google.maps.event.addListener(target, e, event[e]);
                }
            } else {
                if (event[e].hasOwnProperty('func') && 'function' === typeof event[e].func) {
                    if (event[e].hasOwnProperty('once') && true === event[e].once) {
                        google.maps.event.addListenerOnce(target, e, event[e].func);
                    } else {
                        google.maps.event.clearListeners(target, e);
                        google.maps.event.addListener(target, e, event[e].func);
                    }
                } else if ('function' === typeof event[e]) {
                    google.maps.event.clearListeners(target, e);
                    google.maps.event.addListener(target, e, event[e]);
                }
            }
        }
        break;
    }
    // Click for infoWindow
    if (target.hasOwnProperty('defaultInfoWindow')) {
        google.maps.event.clearListeners(target, 'click');
        google.maps.event.addListener(target, 'click', 

            function () {
        	//console.log(this)
        	
            var i = 0,
                m = {};
            // Close all infoWindows if `infoWindowAutoClose` was true.
            if (self.options.hasOwnProperty('infoWindowAutoClose') &&
                true === self.options.infoWindowAutoClose
            ) {
                for (i = 0; i < self._markers.length; i += 1) {
                    m = self._markers[i];
                    if (m.hasOwnProperty('infoWindow') &&
                        'function' === typeof m.infoWindow.close
                    ) {
                        m.infoWindow.close();
                    }
                }
            }
            target.infoWindow.open(self.map, target);
        });
    }}
//#!#END