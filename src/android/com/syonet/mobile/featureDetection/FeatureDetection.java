package com.syonet.mobile.featureDetection;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class FeatureDetection extends CordovaPlugin {

    private static final String FEATURE_DETECTION_TAG = "FeatureDetection";

    @Override
    public boolean execute (
        String action,
        JSONArray args,
        CallbackContext callbackContext
    ) throws JSONException {
        action = action.toLowerCase();
        switch ( action ) {
            case "camera":
                this.hasFeature( PackageManager.FEATURE_CAMERA, callbackContext );
                break;

            default:
                Log.d( FEATURE_DETECTION_TAG, "unknown feature" );
                callbackContext.sendPluginResult( new PluginResult(
                    PluginResult.Status.INVALID_ACTION,
                    false
                ));
                break;
        }

        return true;
    }

    private synchronized void hasFeature ( String feature, CallbackContext callbackContext ) {
        Context context = this.cordova.getActivity().getApplicationContext();
        boolean exists = context.getPackageManager().hasSystemFeature( feature );
        callbackContext.sendPluginResult( new PluginResult( PluginResult.Status.OK, exists ) );
    }
}
