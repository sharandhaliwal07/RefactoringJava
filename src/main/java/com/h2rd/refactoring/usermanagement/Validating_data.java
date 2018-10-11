<<<<<<< HEAD
package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;

public class Validating_data {

    public final static String USER_ROLE = "Role is missing.";
    public final static String USER_EMAIL = "Email is missing.";
    public final static String USER_NAME = "Name is missing";

    public ArrayList<String> validate_User(User user) {
        ArrayList<String> arrayList_of_validations = new ArrayList<String>();

        if ((user.getRoles() == null || user.getRoles().size() == 0)) {
            arrayList_of_validations.add(USER_ROLE);
        }
        if ((user.getEmail() == null )) {
            arrayList_of_validations.add(USER_EMAIL);

        }
        if ((user.getName() == null )) {
            arrayList_of_validations.add(USER_NAME);
        }
        return arrayList_of_validations;
    }
=======
package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;

public class Validating_data {

    public final static String USER_ROLE = "Role is missing.";
    public final static String USER_EMAIL = "Email is missing.";
    public final static String USER_NAME = "Name is missing";

    public ArrayList<String> validate_User(User user) {
        ArrayList<String> arrayList_of_validations = new ArrayList<String>();

        if ((user.getRoles() == null || user.getRoles().size() == 0)) {
            arrayList_of_validations.add(USER_ROLE);
        }
        if ((user.getEmail() == null )) {
            arrayList_of_validations.add(USER_EMAIL);

        }
        if ((user.getName() == null )) {
            arrayList_of_validations.add(USER_NAME);
        }
        return arrayList_of_validations;
    }
>>>>>>> 9f89510eaff30d3681205075b5746da97169122a
}