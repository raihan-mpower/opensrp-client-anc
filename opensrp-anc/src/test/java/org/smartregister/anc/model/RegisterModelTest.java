package org.smartregister.anc.model;

import android.util.Pair;

import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.smartregister.anc.BuildConfig;
import org.smartregister.anc.activity.BaseUnitTest;
import org.smartregister.anc.contract.RegisterContract;
import org.smartregister.anc.util.DBConstants;
import org.smartregister.anc.util.JsonFormUtils;
import org.smartregister.clientandeventmodel.Client;
import org.smartregister.clientandeventmodel.Event;
import org.smartregister.repository.AllSharedPreferences;
import org.smartregister.util.FormUtils;

import java.util.Date;

public class RegisterModelTest extends BaseUnitTest {

    private RegisterContract.Model model;

    private String json = "{\n" +
            "  \"count\": \"1\",\n" +
            "  \"encounter_type\": \"ANC Registration\",\n" +
            "  \"entity_id\": \"\",\n" +
            "  \"relational_id\": \"\",\n" +
            "  \"metadata\": {\n" +
            "    \"start\": {\n" +
            "      \"openmrs_entity_parent\": \"\",\n" +
            "      \"openmrs_entity\": \"concept\",\n" +
            "      \"openmrs_data_type\": \"start\",\n" +
            "      \"openmrs_entity_id\": \"163137AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"\n" +
            "    },\n" +
            "    \"end\": {\n" +
            "      \"openmrs_entity_parent\": \"\",\n" +
            "      \"openmrs_entity\": \"concept\",\n" +
            "      \"openmrs_data_type\": \"end\",\n" +
            "      \"openmrs_entity_id\": \"163138AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"\n" +
            "    },\n" +
            "    \"today\": {\n" +
            "      \"openmrs_entity_parent\": \"\",\n" +
            "      \"openmrs_entity\": \"encounter\",\n" +
            "      \"openmrs_entity_id\": \"encounter_date\"\n" +
            "    },\n" +
            "    \"deviceid\": {\n" +
            "      \"openmrs_entity_parent\": \"\",\n" +
            "      \"openmrs_entity\": \"concept\",\n" +
            "      \"openmrs_data_type\": \"deviceid\",\n" +
            "      \"openmrs_entity_id\": \"163149AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"\n" +
            "    },\n" +
            "    \"subscriberid\": {\n" +
            "      \"openmrs_entity_parent\": \"\",\n" +
            "      \"openmrs_entity\": \"concept\",\n" +
            "      \"openmrs_data_type\": \"subscriberid\",\n" +
            "      \"openmrs_entity_id\": \"163150AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"\n" +
            "    },\n" +
            "    \"simserial\": {\n" +
            "      \"openmrs_entity_parent\": \"\",\n" +
            "      \"openmrs_entity\": \"concept\",\n" +
            "      \"openmrs_data_type\": \"simserial\",\n" +
            "      \"openmrs_entity_id\": \"163151AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"\n" +
            "    },\n" +
            "    \"phonenumber\": {\n" +
            "      \"openmrs_entity_parent\": \"\",\n" +
            "      \"openmrs_entity\": \"concept\",\n" +
            "      \"openmrs_data_type\": \"phonenumber\",\n" +
            "      \"openmrs_entity_id\": \"163152AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"\n" +
            "    },\n" +
            "    \"encounter_location\": \"\",\n" +
            "    \"look_up\": {\n" +
            "      \"entity_id\": \"\",\n" +
            "      \"value\": \"\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"step1\": {\n" +
            "    \"title\": \"Woman Registration\",\n" +
            "    \"fields\": [\n" +
            "      {\n" +
            "        \"key\": \"photo\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"\",\n" +
            "        \"openmrs_entity_id\": \"\",\n" +
            "        \"type\": \"choose_image\",\n" +
            "        \"uploadButtonText\": \"Take a picture of the woman\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"anc_id\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person_identifier\",\n" +
            "        \"openmrs_entity_id\": \"ANC_ID\",\n" +
            "        \"type\": \"barcode\",\n" +
            "        \"barcode_type\": \"qrcode\",\n" +
            "        \"hint\": \"ANC ID *\",\n" +
            "        \"value\": \"0\",\n" +
            "        \"scanButtonText\": \"Scan QR Code\",\n" +
            "        \"v_numeric\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Please enter a valid ANC ID\"\n" +
            "        },\n" +
            "        \"v_required\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Please enter the Woman's ANC ID\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"first_name\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person\",\n" +
            "        \"openmrs_entity_id\": \"first_name\",\n" +
            "        \"type\": \"edit_text\",\n" +
            "        \"hint\": \"First name *\",\n" +
            "        \"edit_type\": \"name\",\n" +
            "        \"v_required\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Please enter the first name\"\n" +
            "        },\n" +
            "        \"v_regex\": {\n" +
            "          \"value\": \"[A-Za-z\\\\s\\.\\-]*\",\n" +
            "          \"err\": \"Please enter a valid name\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"last_name\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person\",\n" +
            "        \"openmrs_entity_id\": \"last_name\",\n" +
            "        \"type\": \"edit_text\",\n" +
            "        \"hint\": \"Last name *\",\n" +
            "        \"edit_type\": \"name\",\n" +
            "        \"v_required\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Please enter the last name\"\n" +
            "        },\n" +
            "        \"v_regex\": {\n" +
            "          \"value\": \"[A-Za-z\\\\s\\.\\-]*\",\n" +
            "          \"err\": \"Please enter a valid name\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"Sex\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person\",\n" +
            "        \"openmrs_entity_id\": \"gender\",\n" +
            "        \"type\": \"hidden\",\n" +
            "        \"value\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"dob\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person\",\n" +
            "        \"openmrs_entity_id\": \"birthdate\",\n" +
            "        \"type\": \"date_picker\",\n" +
            "        \"hint\": \"Date of birth(DOB) *\",\n" +
            "        \"expanded\": false,\n" +
            "        \"duration\": {\n" +
            "          \"label\": \"Age\"\n" +
            "        },\n" +
            "        \"min_date\": \"today-49y\",\n" +
            "        \"max_date\": \"today-15y\",\n" +
            "        \"v_required\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Please enter the date of birth\"\n" +
            "        },\n" +
            "        \"relevance\": {\n" +
            "          \"step1:isDateOfBirthUnknown\": {\n" +
            "            \"type\": \"string\",\n" +
            "            \"ex\": \"equalTo(., \\\"false\\\")\"\n" +
            "          }\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"isDateOfBirthUnknown\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"\",\n" +
            "        \"openmrs_entity_id\": \"\",\n" +
            "        \"type\": \"check_box\",\n" +
            "        \"label\": \"\",\n" +
            "        \"options\": [\n" +
            "          {\n" +
            "            \"key\": \"isDateOfBirthUnknown\",\n" +
            "            \"text\": \"DOB unknown?\",\n" +
            "            \"value\": \"false\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"age\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person_attribute\",\n" +
            "        \"openmrs_entity_id\": \"age_entered\",\n" +
            "        \"type\": \"edit_text\",\n" +
            "        \"hint\": \"Enter Age if DOB unknown *\",\n" +
            "        \"v_numeric\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Number must begin with 0 and must be a total of 10 digits in length\"\n" +
            "        },\n" +
            "        \"v_regex\": {\n" +
            "          \"value\": \"([1][5-9])|([2-4][0-9])|\\s*\",\n" +
            "          \"err\": \"Number must in the range 15 to 49\"\n" +
            "        },\n" +
            "        \"v_required\": {\n" +
            "          \"value\": false\n" +
            "        },\n" +
            "        \"relevance\": {\n" +
            "          \"step1:isDateOfBirthUnknown\": {\n" +
            "            \"type\": \"string\",\n" +
            "            \"ex\": \"equalTo(., \\\"true\\\")\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"v_required\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Please enter the woman's age\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"home_address\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person_attribute\",\n" +
            "        \"openmrs_entity_id\": \"home_address\",\n" +
            "        \"openmrs_data_type\": \"text\",\n" +
            "        \"type\": \"edit_text\",\n" +
            "        \"hint\": \"Home address *\",\n" +
            "        \"v_required\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Please enter the woman's home address\"\n" +
            "        },\n" +
            "        \"v_regex\": {\n" +
            "          \"value\": \"[A-Za-z0-9\\\\s\\.\\-]*\",\n" +
            "          \"err\": \"Please enter a valid name\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"phone_number\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person_attribute\",\n" +
            "        \"openmrs_entity_id\": \"phone_number\",\n" +
            "        \"type\": \"edit_text\",\n" +
            "        \"hint\": \"Mobile phone number *\",\n" +
            "        \"v_numeric\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Number must be a total of 10 digits in length\"\n" +
            "        },\n" +
            "        \"v_regex\": {\n" +
            "          \"value\": \"([0-9]{10})|\\s*\",\n" +
            "          \"err\": \"Number must be a total of 10 digits in length\"\n" +
            "        },\n" +
            "        \"v_required\": {\n" +
            "          \"value\": true,\n" +
            "          \"err\": \"Please specify the woman's phone number\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"alt_name\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person_attribute\",\n" +
            "        \"openmrs_entity_id\": \"alt_name\",\n" +
            "        \"type\": \"edit_text\",\n" +
            "        \"hint\": \"Alternate contact name\",\n" +
            "        \"edit_type\": \"name\",\n" +
            "        \"look_up\": \"true\",\n" +
            "        \"entity_id\": \"\",\n" +
            "        \"v_regex\": {\n" +
            "          \"value\": \"[A-Za-z\\\\s\\.\\-]*\",\n" +
            "          \"err\": \"Please enter a valid VHT name\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"key\": \"alt_phone_number\",\n" +
            "        \"openmrs_entity_parent\": \"\",\n" +
            "        \"openmrs_entity\": \"person_attribute\",\n" +
            "        \"openmrs_entity_id\": \"alt_phone_number\",\n" +
            "        \"type\": \"edit_text\",\n" +
            "        \"hint\": \"Alternate contact phone number\",\n" +
            "        \"v_numeric\": {\n" +
            "          \"value\": \"true\",\n" +
            "          \"err\": \"Number must be a total of 10 digits in length\"\n" +
            "        },\n" +
            "        \"v_regex\": {\n" +
            "          \"value\": \"([0-9]{10})|\\s*\",\n" +
            "          \"err\": \"Number must be a total of 10 digits in length\"\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    
    @Before
    public void setUp() {
        model = new RegisterModel();
    }

    @Test
    public void testProgressRegistration() {
        String jsonString = "{\"count\":\"1\",\"encounter_type\":\"ANC Registration\",\"entity_id\":\"\",\"relational_id\":\"\",\"metadata\":{\"start\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"start\",\"openmrs_entity_id\":\"163137AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"value\":\"2018-07-25 04:40:18\"},\"end\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"end\",\"openmrs_entity_id\":\"163138AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"value\":\"2018-07-25 04:40:54\"},\"today\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"encounter\",\"openmrs_entity_id\":\"encounter_date\",\"value\":\"25-07-2018\"},\"deviceid\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"deviceid\",\"openmrs_entity_id\":\"163149AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"value\":\"51bd45e1fa36981e\"},\"subscriberid\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"subscriberid\",\"openmrs_entity_id\":\"163150AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"value\":\"310270000000000\"},\"simserial\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"simserial\",\"openmrs_entity_id\":\"163151AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"value\":\"89014103211118510720\"},\"phonenumber\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"phonenumber\",\"openmrs_entity_id\":\"163152AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"value\":\"15555218135\"},\"encounter_location\":\"44de66fb-e6c6-4bae-92bb-386dfe626eba\",\"look_up\":{\"entity_id\":\"\",\"value\":\"\"}},\"step1\":{\"title\":\"Woman Registration\",\"fields\":[{\"key\":\"photo\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"\",\"openmrs_entity_id\":\"\",\"type\":\"choose_image\",\"uploadButtonText\":\"Take a picture of the woman\"},{\"key\":\"anc_id\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_identifier\",\"openmrs_entity_id\":\"ANC_ID\",\"type\":\"barcode\",\"barcode_type\":\"qrcode\",\"hint\":\"ANC ID *\",\"scanButtonText\":\"Scan QR Code\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Please enter a valid ANC ID\"},\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the Woman's ANC ID\"},\"value\":\"1723154\"},{\"key\":\"first_name\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"first_name\",\"type\":\"edit_text\",\"hint\":\"First name *\",\"edit_type\":\"name\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the first name\"},\"v_regex\":{\"value\":\"[A-Za-z\\\\s.-]*\",\"err\":\"Please enter a valid name\"},\"value\":\"Test_First_Name\"},{\"key\":\"last_name\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"last_name\",\"type\":\"edit_text\",\"hint\":\"Last name *\",\"edit_type\":\"name\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the last name\"},\"v_regex\":{\"value\":\"[A-Za-z\\\\s.-]*\",\"err\":\"Please enter a valid name\"},\"value\":\"Test_Last_Name\"},{\"key\":\"Sex\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"gender\",\"type\":\"hidden\",\"value\":\"female\"},{\"key\":\"dob\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"birthdate\",\"type\":\"date_picker\",\"hint\":\"Date of birth(DOB) *\",\"expanded\":false,\"duration\":{\"label\":\"Age\"},\"min_date\":\"today-49y\",\"max_date\":\"today-15y\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the date of birth\"},\"relevance\":{\"step1:isDateOfBirthUnknown\":{\"type\":\"string\",\"ex\":\"equalTo(., \\\"false\\\")\"}},\"value\":\"25-07-2003\"},{\"key\":\"isDateOfBirthUnknown\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"\",\"openmrs_entity_id\":\"\",\"type\":\"check_box\",\"label\":\"\",\"options\":[{\"key\":\"isDateOfBirthUnknown\",\"text\":\"DOB unknown?\",\"value\":\"false\"}]},{\"key\":\"age\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_attribute\",\"openmrs_entity_id\":\"age_entered\",\"type\":\"edit_text\",\"hint\":\"Enter Age if DOB unknown *\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Number must begin with 0 and must be a total of 10 digits in length\"},\"v_regex\":{\"value\":\"([1][5-9])|([2-4][0-9])|s*\",\"err\":\"Number must in the range 15 to 49\"},\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the woman's age\"},\"relevance\":{\"step1:isDateOfBirthUnknown\":{\"type\":\"string\",\"ex\":\"equalTo(., \\\"true\\\")\"}},\"value\":\"\"},{\"key\":\"home_address\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_attribute\",\"openmrs_entity_id\":\"home_address\",\"openmrs_data_type\":\"text\",\"type\":\"edit_text\",\"hint\":\"Home address *\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the woman's home address\"},\"v_regex\":{\"value\":\"[A-Za-z0-9\\\\s.-]*\",\"err\":\"Please enter a valid name\"},\"value\":\"Test\"},{\"key\":\"phone_number\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_attribute\",\"openmrs_entity_id\":\"phone_number\",\"type\":\"edit_text\",\"hint\":\"Mobile phone number *\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Number must be a total of 10 digits in length\"},\"v_regex\":{\"value\":\"([0-9]{10})|s*\",\"err\":\"Number must be a total of 10 digits in length\"},\"v_required\":{\"value\":true,\"err\":\"Please specify the woman's phone number\"},\"value\":\"0700000000\"},{\"key\":\"alt_name\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_attribute\",\"openmrs_entity_id\":\"alt_name\",\"type\":\"edit_text\",\"hint\":\"Alternate contact name\",\"edit_type\":\"name\",\"look_up\":\"true\",\"entity_id\":\"\",\"v_regex\":{\"value\":\"[A-Za-z\\\\s.-]*\",\"err\":\"Please enter a valid VHT name\"},\"value\":\"Test_Alt_Name\"},{\"key\":\"alt_phone_number\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_attribute\",\"openmrs_entity_id\":\"alt_phone_number\",\"type\":\"edit_text\",\"hint\":\"Alternate contact phone number\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Number must be a total of 10 digits in length\"},\"v_regex\":{\"value\":\"([0-9]{10})|s*\",\"err\":\"Number must be a total of 10 digits in length\"},\"value\":\"0700000001\"}]}}";

        AllSharedPreferences allSharedPreferences = Mockito.mock(AllSharedPreferences.class);

        RegisterModel registerModel = (RegisterModel) model;
        registerModel.setAllSharedPreferences(allSharedPreferences);

        String providerId = "PRoviderID";
        String teamId = "TEAmId";
        String team = "TeAM";
        String locationID = "LocationID";

        Mockito.doReturn(providerId).when(allSharedPreferences).fetchRegisteredANM();
        Mockito.doReturn(locationID).when(allSharedPreferences).fetchDefaultLocalityId(providerId);
        Mockito.doReturn(team).when(allSharedPreferences).fetchDefaultTeam(providerId);
        Mockito.doReturn(teamId).when(allSharedPreferences).fetchDefaultTeamId(providerId);

        Pair<Client, Event> pair = registerModel.processRegistration(jsonString);

        Mockito.verify(allSharedPreferences, Mockito.times(2)).fetchRegisteredANM();
        Mockito.verify(allSharedPreferences).fetchDefaultLocalityId(providerId);
        Mockito.verify(allSharedPreferences).fetchDefaultTeam(providerId);
        Mockito.verify(allSharedPreferences).fetchDefaultTeamId(providerId);

        Client client = pair.first;
        Event event = pair.second;

        Assert.assertNotNull(client);
        Assert.assertNotNull(event);

        Assert.assertEquals(client.getBaseEntityId(), event.getBaseEntityId());

        Assert.assertEquals("Client", client.type());
        Assert.assertEquals(BuildConfig.VERSION_CODE, client.getClientApplicationVersion().intValue());
        Assert.assertEquals(BuildConfig.DATABASE_VERSION, client.getClientDatabaseVersion().intValue());

        Assert.assertEquals(BuildConfig.VERSION_CODE, event.getClientApplicationVersion().intValue());
        Assert.assertEquals(BuildConfig.DATABASE_VERSION, event.getClientDatabaseVersion().intValue());

        Assert.assertTrue(DateUtils.isSameDay(new Date(), client.getDateCreated()));
        Assert.assertTrue(DateUtils.isSameDay(new Date(), event.getDateCreated()));

        Assert.assertEquals("1723154", client.getIdentifier("ANC_ID"));
        Assert.assertEquals(JsonFormUtils.formatDate("25-07-2003", true), client.getBirthdate());
        Assert.assertEquals("Test_First_Name", client.getFirstName());
        Assert.assertEquals("Test_Last_Name", client.getLastName());
        Assert.assertEquals("female", client.getGender());
        Assert.assertEquals("Test", client.getAttribute("home_address"));
        Assert.assertEquals("0700000000", client.getAttribute("phone_number"));
        Assert.assertEquals("Test_Alt_Name", client.getAttribute("alt_name"));
        Assert.assertEquals("0700000001", client.getAttribute("alt_phone_number"));


        Assert.assertEquals(providerId, event.getProviderId());
        Assert.assertEquals("ANC Registration", event.getEventType());
        Assert.assertEquals("LocationID", event.getLocationId());
        Assert.assertEquals("ec_mother", event.getEntityType());
        Assert.assertEquals(JsonFormUtils.formatDate("25-07-2018", true), event.getEventDate());

    }

    @Test
    public void testFormAsJson() throws Exception {

        FormUtils formUtils = Mockito.mock(FormUtils.class);

        RegisterModel registerModel = (RegisterModel) model;
        registerModel.setFormUtils(formUtils);

        String formName = "anc_register";
        String entityId = "ENTITY_ID";
        String currentLocationId = "CURRENT_LOCATION_ID";

        JSONObject jsonInMock = new JSONObject(json);

        Assert.assertNotEquals(currentLocationId, jsonInMock.getJSONObject(JsonFormUtils.METADATA).getString(JsonFormUtils.ENCOUNTER_LOCATION));
        Assert.assertNotEquals(entityId, entityId(jsonInMock));

        Mockito.doReturn(jsonInMock).when(formUtils).getFormJson(formName);

        JSONObject actualJson = registerModel.getFormAsJson(formName, entityId, currentLocationId);

        Mockito.verify(formUtils).getFormJson(formName);

        Assert.assertEquals(currentLocationId, actualJson.getJSONObject(JsonFormUtils.METADATA).getString(JsonFormUtils.ENCOUNTER_LOCATION));

        Assert.assertEquals(entityId, entityId(actualJson));


    }

    private String entityId(JSONObject jsonObject) {
        JSONArray field = JsonFormUtils.fields(jsonObject);
        JSONObject ancId = JsonFormUtils.getFieldJSONObject(field, DBConstants.KEY.ANC_ID);
        return JsonFormUtils.getString(ancId, JsonFormUtils.VALUE);
    }
}
