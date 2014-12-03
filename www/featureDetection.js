var exec = require( "cordova/exec" );

exports.camera = function( success, error ) {
    exec( success, error, "featureDetection", "camera" );
};
