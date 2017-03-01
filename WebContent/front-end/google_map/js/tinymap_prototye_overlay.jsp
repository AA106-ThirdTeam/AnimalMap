/**
 * Overlay processes
 * @private
 */
overlay: function (callback) {

    var map = this.map,
        opt = this.options;

    try {
        if (!this.idleOnceCount) {
            //#!#START KML
            // kml overlay
            this.kml(map, opt);
            //#!#END
            //#!#START DIRECTION
            // direction overlay
            this.directionService(map, opt);
            //#!#END
            //#!#START MARKER
            // markers overlay
            this.placeMarkers(map, opt);
            //#!#END
            //#!#START POLYLINE
            // polyline overlay
            this.drawPolyline(map, opt);
            //#!#END
            //#!#START POLYGON
            // polygon overlay
            this.drawPolygon(map, opt);
            //#!#END
            //#!#START CIRCLE
            // circle overlay
            this.drawCircle(map, opt);
            //#!#END
            //#!#START STREETVIEW
            // StreetView service
            this.streetView(map, opt);
            //#!#END
            //#!#START PLACES
            // PlaceService
            this.places(map, opt);
            //#!#END
            // GeoLocation
            this.geoLocation(map, opt);
            this.idleOnceCount = true;
        }
    } catch (ignore) {
        console.error(ignore);
    } finally {
        google.maps.event.trigger(map, 'resize');
    }
}