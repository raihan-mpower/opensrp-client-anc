package org.smartregister.anc.activity;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.smartregister.anc.BuildConfig;
import org.smartregister.anc.application.TestAncApplication;

/**
 * Created by ndegwamartin on 27/03/2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(application = TestAncApplication.class, constants = BuildConfig.class, sdk = 22)
public abstract class BaseUnitTest {

    public static int ASYNC_TIMEOUT = 1000;

    protected static final String DUMMY_USERNAME = "myusername";
    protected static final String DUMMY_PASSWORD = "mypassword";

}