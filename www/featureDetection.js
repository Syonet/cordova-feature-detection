var exec = require( "cordova/exec" );
[
    "camera"
].forEach(function ( feature ) {
    exports[ feature ] = function ( success, error ) {
        exec( success, error, "FeatureDetection", feature, [] );
    };
});