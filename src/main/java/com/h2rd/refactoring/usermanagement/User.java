<<<<<<< HEAD
package com.h2rd.refactoring.usermanagement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;



/**
 * This class contains the properties of a user using getters and setters
 *@author aldocuevas
 */
public class User {

    String name;
    String email;
    List<String> roles;

    /**
     * Get Name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     *@param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Email
     *@return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * set Email
     *@param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get roles
     *@return List<String>
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * Set Roles
     *@param roles List<String>
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
=======
package com.h2rd.refactoring.usermanagement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;



/**
 * This class contains the properties of a user using getters and setters
 *@author aldocuevas
 */
public class User {

    String name;
    String email;
    List<String> roles;

    /**
     * Get Name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     *@param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Email
     *@return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * set Email
     *@param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get roles
     *@return List<String>
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * Set Roles
     *@param roles List<String>
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
>>>>>>> 9f89510eaff30d3681205075b5746da97169122a
