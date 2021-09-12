package com.example.videomeetingapp.utilities;

import java.util.HashMap;

public class Constants {

    public static final String  KEY_COLLECTION_USER = "user";
    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_FCM_TOKEN = "fcm_token";

    public static final String KEY_PREFERENCE_NAME = "videoMeetingPreference";
    public static final String KEY_IS_SIGNED_IN = "isSignedIn";
    public static final String REMOTE_MSG_AUTHORIZATION = "Authorization";
    public static final String REMOTE_MSG_CONTENT_TYPE = "Content-Type";

    public static final String REMOTE_MSG_TYPE = "type";
    public static final String REMOTE_MSG_INVITATION = "invitation";
    public static final String REMOTE_MSG_MEETING_TYPE = "meetingType";
    public static final String REMOTE_MSG_INVITER_TOKEN ="inviterToken";
    public static final String REMOTE_MSG_DATA = "data";
    public static final String REMOTE_MSG_REGISTRATION_IDS = "registration_ids";

    public static final String REMOTE_MSG_INVITATION_RESPONSE = "invitationResponse";
    public static final String REMOTE_MSG_INVITATION_ACCEPTED = "accepted";
    public static final String REMOTE_MSG_INVITATION_REJECTED = "rejected";
    public static final String REMOTE_MSG_INVITATION_CANCELLED = "cancelled";
    public static final String REMOTE_MGS_MEETING_ROOM = "meetingRoom";




    public static HashMap<String,String> getRemoteMessageHeaders(){

        HashMap<String , String> headers = new HashMap<>();
        headers.put(

                Constants.REMOTE_MSG_AUTHORIZATION,
                "key=AAAACNDvTOA:APA91bG_QxWrg9_4XpfMiRq73smX8vDoD1fxsBKrB5HD88BRjqCp1Fg9ZnZ-dcxkT4RyzGZB7eyLLeXuFf1gyP9NTuWH_TaZH_8iXa1CqFrIsM8ktiUYnzP5WYWeibsml3-AFjGlzel7"
        );

        headers.put(Constants.REMOTE_MSG_CONTENT_TYPE,"application/json");
        return headers;
    }



}
