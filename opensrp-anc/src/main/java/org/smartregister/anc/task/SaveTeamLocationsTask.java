package org.smartregister.anc.task;

import android.os.AsyncTask;

import org.smartregister.anc.helper.LocationHelper;

/**
 * Created by ndegwamartin on 26/06/2018.
 */

public class SaveTeamLocationsTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        LocationHelper.getInstance().locationIdsFromHierarchy();
        return null;
    }

}