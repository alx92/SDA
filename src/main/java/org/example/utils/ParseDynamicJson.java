package org.example.utils;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class ParseDynamicJson {

    // How to parse dynamic JSON
    // How to parse nested JSON

    public static void parseObject(JSONObject json, String key) {
        System.out.println(json.get(key));
    }

    public static void getKey(JSONObject json, String key) {

        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

        if (!exists) {

            keys = json.keys();

            while (keys.hasNext()) {

                nextKeys = (String) keys.next();
                try {

                    if (json.get(nextKeys) instanceof JSONObject) {

                        if (!exists) {
                            getKey(json.getJSONObject(nextKeys), key);
                        }

                    } else if (json.get(nextKeys) instanceof JSONArray) {

                        JSONArray jsonArray = json.getJSONArray(nextKeys);

                        for (int i = 0; i < jsonArray.length(); i++) {

                            String jsonArrString = jsonArray.get(i).toString();

                            // need to check again if JsonObject
                            JSONObject innerJson = new JSONObject(jsonArrString);

                            if (!exists) {
                                getKey(innerJson, key);
                            }
                        }
                    }
                } catch (Exception e) {
                    // handle exception
                }
            }
        } else {
            parseObject(json, key);
        }
    }

//    public static void main(String[] args) {
//        String inputJson = "{\n" +
//                "    \"links\": {\n" +
//                "        \"next\": \"http://www.neowsapp.com/rest/v1/feed?start_date=2017-09-20&end_date=2017-09-20&detailed=false&api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\",\n" +
//                "        \"prev\": \"http://www.neowsapp.com/rest/v1/feed?start_date=2017-09-18&end_date=2017-09-18&detailed=false&api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\",\n" +
//                "        \"self\": \"http://www.neowsapp.com/rest/v1/feed?start_date=2017-09-19&end_date=2017-09-19&detailed=false&api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "    },\n" +
//                "    \"element_count\": 15,\n" +
//                "    \"near_earth_objects\": {\n" +
//                "        \"2017-09-19\": [\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3781893?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3781893\",\n" +
//                "                \"neo_reference_id\": \"3781893\",\n" +
//                "                \"name\": \"(2017 SG16)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781893\",\n" +
//                "                \"absolute_magnitude_h\": 26.5,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0133215567,\n" +
//                "                        \"estimated_diameter_max\": 0.0297879063\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 13.3215566698,\n" +
//                "                        \"estimated_diameter_max\": 29.7879062798\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.008277629,\n" +
//                "                        \"estimated_diameter_max\": 0.0185093411\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 43.7058959846,\n" +
//                "                        \"estimated_diameter_max\": 97.7293544391\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 02:47\",\n" +
//                "                        \"epoch_date_close_approach\": 1505789220000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"6.8603443267\",\n" +
//                "                            \"kilometers_per_hour\": \"24697.2395760002\",\n" +
//                "                            \"miles_per_hour\": \"15345.9042243208\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.0330378807\",\n" +
//                "                            \"lunar\": \"12.8517355923\",\n" +
//                "                            \"kilometers\": \"4942396.582034109\",\n" +
//                "                            \"miles\": \"3071062.8290003442\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3781403?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3781403\",\n" +
//                "                \"neo_reference_id\": \"3781403\",\n" +
//                "                \"name\": \"(2017 RG2)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781403\",\n" +
//                "                \"absolute_magnitude_h\": 24.4,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0350392641,\n" +
//                "                        \"estimated_diameter_max\": 0.0783501764\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 35.0392641108,\n" +
//                "                        \"estimated_diameter_max\": 78.3501764334\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0217723826,\n" +
//                "                        \"estimated_diameter_max\": 0.0486845275\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 114.9582192654,\n" +
//                "                        \"estimated_diameter_max\": 257.0543928497\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 18:35\",\n" +
//                "                        \"epoch_date_close_approach\": 1505846100000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"8.4287728242\",\n" +
//                "                            \"kilometers_per_hour\": \"30343.5821672099\",\n" +
//                "                            \"miles_per_hour\": \"18854.3219305089\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.0201790546\",\n" +
//                "                            \"lunar\": \"7.8496522394\",\n" +
//                "                            \"kilometers\": \"3018743.586773702\",\n" +
//                "                            \"miles\": \"1875760.2846610076\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3020944?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3020944\",\n" +
//                "                \"neo_reference_id\": \"3020944\",\n" +
//                "                \"name\": \"(1999 HD1)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3020944\",\n" +
//                "                \"absolute_magnitude_h\": 20.4,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.2210828104,\n" +
//                "                        \"estimated_diameter_max\": 0.4943561926\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 221.0828103591,\n" +
//                "                        \"estimated_diameter_max\": 494.3561926196\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.137374447,\n" +
//                "                        \"estimated_diameter_max\": 0.3071786018\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 725.3373275385,\n" +
//                "                        \"estimated_diameter_max\": 1621.9035709942\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": null,\n" +
//                "                        \"epoch_date_close_approach\": 1505804400000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"17.147264206\",\n" +
//                "                            \"kilometers_per_hour\": \"61730.1511415474\",\n" +
//                "                            \"miles_per_hour\": \"38356.7153023687\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.3755096656\",\n" +
//                "                            \"lunar\": \"146.0732599184\",\n" +
//                "                            \"kilometers\": \"56175446.138172272\",\n" +
//                "                            \"miles\": \"34905803.6266384736\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3785711?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3785711\",\n" +
//                "                \"neo_reference_id\": \"3785711\",\n" +
//                "                \"name\": \"(2017 SE33)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3785711\",\n" +
//                "                \"absolute_magnitude_h\": 27.7,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0076657557,\n" +
//                "                        \"estimated_diameter_max\": 0.0171411509\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 7.6657557353,\n" +
//                "                        \"estimated_diameter_max\": 17.1411509231\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0047632783,\n" +
//                "                        \"estimated_diameter_max\": 0.0106510141\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 25.1501180466,\n" +
//                "                        \"estimated_diameter_max\": 56.2373735944\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 00:58\",\n" +
//                "                        \"epoch_date_close_approach\": 1505782680000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"8.896427323\",\n" +
//                "                            \"kilometers_per_hour\": \"32027.1383627437\",\n" +
//                "                            \"miles_per_hour\": \"19900.4182787837\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.0184692576\",\n" +
//                "                            \"lunar\": \"7.1845412064\",\n" +
//                "                            \"kilometers\": \"2762961.597441312\",\n" +
//                "                            \"miles\": \"1716824.7264296256\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3545516?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3545516\",\n" +
//                "                \"neo_reference_id\": \"3545516\",\n" +
//                "                \"name\": \"(2010 RE12)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3545516\",\n" +
//                "                \"absolute_magnitude_h\": 22.1,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.1010543415,\n" +
//                "                        \"estimated_diameter_max\": 0.2259643771\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 101.054341542,\n" +
//                "                        \"estimated_diameter_max\": 225.9643771094\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0627922373,\n" +
//                "                        \"estimated_diameter_max\": 0.140407711\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 331.5431259047,\n" +
//                "                        \"estimated_diameter_max\": 741.3529669956\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 10:08\",\n" +
//                "                        \"epoch_date_close_approach\": 1505815680000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"3.4567200339\",\n" +
//                "                            \"kilometers_per_hour\": \"12444.1921218909\",\n" +
//                "                            \"miles_per_hour\": \"7732.3370437382\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.4373635351\",\n" +
//                "                            \"lunar\": \"170.1344151539\",\n" +
//                "                            \"kilometers\": \"65428653.266630237\",\n" +
//                "                            \"miles\": \"40655479.9202297906\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3788117?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3788117\",\n" +
//                "                \"neo_reference_id\": \"3788117\",\n" +
//                "                \"name\": \"(2017 UA8)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3788117\",\n" +
//                "                \"absolute_magnitude_h\": 21.4,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.1394938229,\n" +
//                "                        \"estimated_diameter_max\": 0.3119176705\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 139.4938229344,\n" +
//                "                        \"estimated_diameter_max\": 311.9176705226\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0866774163,\n" +
//                "                        \"estimated_diameter_max\": 0.1938165949\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 457.6569140361,\n" +
//                "                        \"estimated_diameter_max\": 1023.3519701574\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 05:11\",\n" +
//                "                        \"epoch_date_close_approach\": 1505797860000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"3.3096285032\",\n" +
//                "                            \"kilometers_per_hour\": \"11914.6626113679\",\n" +
//                "                            \"miles_per_hour\": \"7403.3079987136\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.2968646078\",\n" +
//                "                            \"lunar\": \"115.4803324342\",\n" +
//                "                            \"kilometers\": \"44410313.005265386\",\n" +
//                "                            \"miles\": \"27595288.8909228868\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3781465?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3781465\",\n" +
//                "                \"neo_reference_id\": \"3781465\",\n" +
//                "                \"name\": \"(2017 RX15)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781465\",\n" +
//                "                \"absolute_magnitude_h\": 22.6,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0802703167,\n" +
//                "                        \"estimated_diameter_max\": 0.1794898848\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 80.2703167283,\n" +
//                "                        \"estimated_diameter_max\": 179.4898847799\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.049877647,\n" +
//                "                        \"estimated_diameter_max\": 0.1115298092\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 263.3540659348,\n" +
//                "                        \"estimated_diameter_max\": 588.8775935812\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 17:14\",\n" +
//                "                        \"epoch_date_close_approach\": 1505841240000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"10.3243278429\",\n" +
//                "                            \"kilometers_per_hour\": \"37167.5802345462\",\n" +
//                "                            \"miles_per_hour\": \"23094.488951849\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.2007996605\",\n" +
//                "                            \"lunar\": \"78.1110679345\",\n" +
//                "                            \"kilometers\": \"30039201.507523135\",\n" +
//                "                            \"miles\": \"18665494.286303863\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3781300?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3781300\",\n" +
//                "                \"neo_reference_id\": \"3781300\",\n" +
//                "                \"name\": \"(2017 QX34)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781300\",\n" +
//                "                \"absolute_magnitude_h\": 21.5,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.1332155667,\n" +
//                "                        \"estimated_diameter_max\": 0.2978790628\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 133.2155666981,\n" +
//                "                        \"estimated_diameter_max\": 297.8790627982\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0827762899,\n" +
//                "                        \"estimated_diameter_max\": 0.1850934111\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 437.0589598459,\n" +
//                "                        \"estimated_diameter_max\": 977.2935443908\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 22:59\",\n" +
//                "                        \"epoch_date_close_approach\": 1505861940000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"12.662130768\",\n" +
//                "                            \"kilometers_per_hour\": \"45583.6707646664\",\n" +
//                "                            \"miles_per_hour\": \"28323.9203148562\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.4775091251\",\n" +
//                "                            \"lunar\": \"185.7510496639\",\n" +
//                "                            \"kilometers\": \"71434348.020523537\",\n" +
//                "                            \"miles\": \"44387245.5960253306\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3781729?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3781729\",\n" +
//                "                \"neo_reference_id\": \"3781729\",\n" +
//                "                \"name\": \"(2017 SD12)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781729\",\n" +
//                "                \"absolute_magnitude_h\": 25.0,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.02658,\n" +
//                "                        \"estimated_diameter_max\": 0.0594346868\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 26.58,\n" +
//                "                        \"estimated_diameter_max\": 59.4346868419\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0165160412,\n" +
//                "                        \"estimated_diameter_max\": 0.0369309908\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 87.2047272,\n" +
//                "                        \"estimated_diameter_max\": 194.9956979785\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 17:08\",\n" +
//                "                        \"epoch_date_close_approach\": 1505840880000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"8.0301199378\",\n" +
//                "                            \"kilometers_per_hour\": \"28908.4317759528\",\n" +
//                "                            \"miles_per_hour\": \"17962.5752887858\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.0083164638\",\n" +
//                "                            \"lunar\": \"3.2351044182\",\n" +
//                "                            \"kilometers\": \"1244125.270412106\",\n" +
//                "                            \"miles\": \"773063.5955988228\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3781585?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3781585\",\n" +
//                "                \"neo_reference_id\": \"3781585\",\n" +
//                "                \"name\": \"(2017 SK2)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781585\",\n" +
//                "                \"absolute_magnitude_h\": 23.2,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0608912622,\n" +
//                "                        \"estimated_diameter_max\": 0.1361570015\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 60.8912622106,\n" +
//                "                        \"estimated_diameter_max\": 136.1570015386\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0378360645,\n" +
//                "                        \"estimated_diameter_max\": 0.0846040122\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 199.7744887109,\n" +
//                "                        \"estimated_diameter_max\": 446.7093369279\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 13:46\",\n" +
//                "                        \"epoch_date_close_approach\": 1505828760000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"7.0631120486\",\n" +
//                "                            \"kilometers_per_hour\": \"25427.2033749654\",\n" +
//                "                            \"miles_per_hour\": \"15799.4753415167\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.2549819301\",\n" +
//                "                            \"lunar\": \"99.1879708089\",\n" +
//                "                            \"kilometers\": \"38144753.631448887\",\n" +
//                "                            \"miles\": \"23702050.8278811606\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3781983?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3781983\",\n" +
//                "                \"neo_reference_id\": \"3781983\",\n" +
//                "                \"name\": \"(2017 SA20)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781983\",\n" +
//                "                \"absolute_magnitude_h\": 28.2,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0060891262,\n" +
//                "                        \"estimated_diameter_max\": 0.0136157002\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 6.0891262211,\n" +
//                "                        \"estimated_diameter_max\": 13.6157001539\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0037836064,\n" +
//                "                        \"estimated_diameter_max\": 0.0084604012\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 19.9774488711,\n" +
//                "                        \"estimated_diameter_max\": 44.6709336928\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 22:27\",\n" +
//                "                        \"epoch_date_close_approach\": 1505860020000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"5.8643521608\",\n" +
//                "                            \"kilometers_per_hour\": \"21111.6677789736\",\n" +
//                "                            \"miles_per_hour\": \"13117.9693485517\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.0039380432\",\n" +
//                "                            \"lunar\": \"1.5318988048\",\n" +
//                "                            \"kilometers\": \"589122.874687984\",\n" +
//                "                            \"miles\": \"366063.9797188192\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/2488474?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"2488474\",\n" +
//                "                \"neo_reference_id\": \"2488474\",\n" +
//                "                \"name\": \"488474 (1999 HD1)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2488474\",\n" +
//                "                \"absolute_magnitude_h\": 20.3,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.2315021222,\n" +
//                "                        \"estimated_diameter_max\": 0.5176544822\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 231.5021222103,\n" +
//                "                        \"estimated_diameter_max\": 517.6544821978\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.1438487052,\n" +
//                "                        \"estimated_diameter_max\": 0.3216554833\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 759.5214226325,\n" +
//                "                        \"estimated_diameter_max\": 1698.3415313737\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 10:15\",\n" +
//                "                        \"epoch_date_close_approach\": 1505816100000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"17.1472518083\",\n" +
//                "                            \"kilometers_per_hour\": \"61730.1065100341\",\n" +
//                "                            \"miles_per_hour\": \"38356.687570082\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.375509539\",\n" +
//                "                            \"lunar\": \"146.073210671\",\n" +
//                "                            \"kilometers\": \"56175427.19908193\",\n" +
//                "                            \"miles\": \"34905791.858433434\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3647016?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3647016\",\n" +
//                "                \"neo_reference_id\": \"3647016\",\n" +
//                "                \"name\": \"(2013 RO5)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3647016\",\n" +
//                "                \"absolute_magnitude_h\": 24.8,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0291443905,\n" +
//                "                        \"estimated_diameter_max\": 0.0651688382\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 29.1443904535,\n" +
//                "                        \"estimated_diameter_max\": 65.1688382168\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.018109479,\n" +
//                "                        \"estimated_diameter_max\": 0.0404940262\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 95.6180819754,\n" +
//                "                        \"estimated_diameter_max\": 213.8085311752\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 19:00\",\n" +
//                "                        \"epoch_date_close_approach\": 1505847600000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"12.2256025998\",\n" +
//                "                            \"kilometers_per_hour\": \"44012.16935933\",\n" +
//                "                            \"miles_per_hour\": \"27347.4504555237\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.1700851888\",\n" +
//                "                            \"lunar\": \"66.1631384432\",\n" +
//                "                            \"kilometers\": \"25444381.963027856\",\n" +
//                "                            \"miles\": \"15810405.8135661728\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/3759755?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"3759755\",\n" +
//                "                \"neo_reference_id\": \"3759755\",\n" +
//                "                \"name\": \"(2016 SP2)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3759755\",\n" +
//                "                \"absolute_magnitude_h\": 24.1,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.040230458,\n" +
//                "                        \"estimated_diameter_max\": 0.0899580388\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 40.2304579834,\n" +
//                "                        \"estimated_diameter_max\": 89.9580388169\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0249980399,\n" +
//                "                        \"estimated_diameter_max\": 0.0558973165\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 131.9896957704,\n" +
//                "                        \"estimated_diameter_max\": 295.1379320721\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 21:59\",\n" +
//                "                        \"epoch_date_close_approach\": 1505858340000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"7.2323911023\",\n" +
//                "                            \"kilometers_per_hour\": \"26036.6079683822\",\n" +
//                "                            \"miles_per_hour\": \"16178.1356567984\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.1759102982\",\n" +
//                "                            \"lunar\": \"68.4291059998\",\n" +
//                "                            \"kilometers\": \"26315805.921784834\",\n" +
//                "                            \"miles\": \"16351883.5528813492\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"links\": {\n" +
//                "                    \"self\": \"http://www.neowsapp.com/rest/v1/neo/54017213?api_key=F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF\"\n" +
//                "                },\n" +
//                "                \"id\": \"54017213\",\n" +
//                "                \"neo_reference_id\": \"54017213\",\n" +
//                "                \"name\": \"(2020 KB4)\",\n" +
//                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54017213\",\n" +
//                "                \"absolute_magnitude_h\": 26.952,\n" +
//                "                \"estimated_diameter\": {\n" +
//                "                    \"kilometers\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0108181993,\n" +
//                "                        \"estimated_diameter_max\": 0.0241902289\n" +
//                "                    },\n" +
//                "                    \"meters\": {\n" +
//                "                        \"estimated_diameter_min\": 10.8181992643,\n" +
//                "                        \"estimated_diameter_max\": 24.1902289492\n" +
//                "                    },\n" +
//                "                    \"miles\": {\n" +
//                "                        \"estimated_diameter_min\": 0.0067221153,\n" +
//                "                        \"estimated_diameter_max\": 0.0150311068\n" +
//                "                    },\n" +
//                "                    \"feet\": {\n" +
//                "                        \"estimated_diameter_min\": 35.4927808744,\n" +
//                "                        \"estimated_diameter_max\": 79.3642707456\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"is_potentially_hazardous_asteroid\": false,\n" +
//                "                \"close_approach_data\": [\n" +
//                "                    {\n" +
//                "                        \"close_approach_date\": \"2017-09-19\",\n" +
//                "                        \"close_approach_date_full\": \"2017-Sep-19 05:52\",\n" +
//                "                        \"epoch_date_close_approach\": 1505800320000,\n" +
//                "                        \"relative_velocity\": {\n" +
//                "                            \"kilometers_per_second\": \"7.4205919494\",\n" +
//                "                            \"kilometers_per_hour\": \"26714.1310179332\",\n" +
//                "                            \"miles_per_hour\": \"16599.1221316708\"\n" +
//                "                        },\n" +
//                "                        \"miss_distance\": {\n" +
//                "                            \"astronomical\": \"0.2924070152\",\n" +
//                "                            \"lunar\": \"113.7463289128\",\n" +
//                "                            \"kilometers\": \"43743466.646977624\",\n" +
//                "                            \"miles\": \"27180929.7779702512\"\n" +
//                "                        },\n" +
//                "                        \"orbiting_body\": \"Earth\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"is_sentry_object\": false\n" +
//                "            }\n" +
//                "        ]\n" +
//                "    }\n" +
//                "}";
//
//        JSONObject inputJsonObject = new JSONObject(inputJson);
//
//        getKey(inputJsonObject, "links");
//    }
}
