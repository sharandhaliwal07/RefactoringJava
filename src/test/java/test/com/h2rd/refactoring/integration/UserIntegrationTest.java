<<<<<<< HEAD
package test.com.h2rd.refactoring.integration;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.web.UserResource;

public class UserIntegrationTest {
	
	@Test
	public void createUserTest() {
		UserResource userResource = new UserResource();
		
		User integration = new User();
        integration.setName("integration");
        integration.setEmail("initial@integration.com");
        integration.setRoles(Arrays.asList("admin"));
        
        Response response = userResource.addUser(integration.getName(), integration.getEmail(), integration.getRoles());
        Assert.assertEquals(200, response.getStatus());
	}

    public void Testfail() {
        UserResource userResource = new UserResource();

        User integration = new User();
        integration.setName("initial");
        integration.setEmail("integration@integration.com");
        integration.setRoles(new ArrayList<String>());

        Response response = userResource.addUser(integration.getName(), integration.getEmail(), integration.getRoles());
        Assert.assertEquals(403, response.getStatus());
    }
	@Test
    public void updateUserTest() {
        UserResource userResource = new UserResource();

        User integration = new User();
        integration.setName("integration1");
        integration.setEmail("initial1@integration.com");
        integration.setRoles(Arrays.asList("admin"));

        Response response = userResource.addUser(integration.getName(), integration.getEmail(), integration.getRoles());

        User updated = new User();
        updated.setName("updated");
        updated.setEmail("initial1@integration.com");
        updated.setRoles(Arrays.asList("admin", "master"));

        response = userResource.updateUser(updated.getName(), updated.getEmail(), updated.getRoles());
        Assert.assertEquals(200, response.getStatus());

    }
}


=======
package test.com.h2rd.refactoring.integration;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.web.UserResource;

public class UserIntegrationTest {
	
	@Test
	public void createUserTest() {
		UserResource userResource = new UserResource();
		
		User integration = new User();
        integration.setName("integration");
        integration.setEmail("initial@integration.com");
        integration.setRoles(Arrays.asList("admin"));
        
        Response response = userResource.addUser(integration.getName(), integration.getEmail(), integration.getRoles());
        Assert.assertEquals(200, response.getStatus());
	}

    public void Testfail() {
        UserResource userResource = new UserResource();

        User integration = new User();
        integration.setName("initial");
        integration.setEmail("integration@integration.com");
        integration.setRoles(new ArrayList<String>());

        Response response = userResource.addUser(integration.getName(), integration.getEmail(), integration.getRoles());
        Assert.assertEquals(403, response.getStatus());
    }
	@Test
    public void updateUserTest() {
        UserResource userResource = new UserResource();

        User integration = new User();
        integration.setName("integration1");
        integration.setEmail("initial1@integration.com");
        integration.setRoles(Arrays.asList("admin"));

        Response response = userResource.addUser(integration.getName(), integration.getEmail(), integration.getRoles());

        User updated = new User();
        updated.setName("updated");
        updated.setEmail("initial1@integration.com");
        updated.setRoles(Arrays.asList("admin", "master"));

        response = userResource.updateUser(updated.getName(), updated.getEmail(), updated.getRoles());
        Assert.assertEquals(200, response.getStatus());

    }
}


>>>>>>> 9f89510eaff30d3681205075b5746da97169122a
