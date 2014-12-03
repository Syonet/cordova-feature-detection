# Feature Detection
Cordova plugin for device feature detection.

## Detectable features
* `camera` - Detects if a camera is available

## Installation
```shell
cordova plugin add com.syonet.mobile.featuredetection
```

## Usage
```javascript
cordova.plugins.featureDetection.<feature name>(function ( result ) {
    console.log( result );
}, function ( err ) {
    console.log( err );
});
```

## Supported platforms
* Android

## License
MIT