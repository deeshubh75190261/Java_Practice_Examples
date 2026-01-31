package Demo;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class CheckLdapStatus {

	public static void main(String[] args) {
		boolean userAuth = checkLdapAuthentication("ltgd_recon", "J@ly#2@23N$$D");
		System.out.println("userStatus:" + userAuth);

	}

	public static boolean checkLdapAuthentication(String userId, String password) {

		Hashtable<String, Object> authEnv = new Hashtable<String, Object>();
		//String dn = "";
		String ldapURL = "";
		boolean ldapResponce = true;
		String provider = "";
		
		String base ="DC=PSLTESTDOMAIN,DC=LOCAL";
		String dn = "cn=" + "ltgs_recon" + "," + base;

		// LdapContext ctx = null;
		DirContext ctx = null;

		try {
			ldapURL = "LDAP://cloudldap.lntfinsvcs.com:389";

			provider = "com.sun.jndi.ldap.LdapCtxFactory";

			//dn = "cn=USERID,LNTFINSVCS,DC=COM".replace("USERID", userId);

			authEnv.put(Context.INITIAL_CONTEXT_FACTORY, provider);
			authEnv.put(Context.PROVIDER_URL, ldapURL);
			authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
			authEnv.put(Context.SECURITY_PRINCIPAL, dn);
			authEnv.put(Context.SECURITY_CREDENTIALS, password);

			// ctx = new InitialLdapContext(authEnv, null);

			ctx = new InitialDirContext(authEnv);

			ldapResponce = true;

		} catch (Exception ex) {
			ldapResponce = false;
			ex.printStackTrace();
		} /*
			 * catch (AuthenticationException authEx) { ldapResponce = false;
			 * System.out.println("1:" + authEx.getMessage()); } catch (NamingException
			 * namEx) { ldapResponce = false; System.out.println("2:" + namEx.getMessage());
			 * namEx.printStackTrace(); } catch (Exception e) { ldapResponce = false;
			 * System.out.println("4:" + e.getMessage()); } catch (Throwable e) {
			 * ldapResponce = false; System.out.println("5:" + e.getMessage()); }
			 */
		System.out.println("ldapResponce:" + ldapResponce);
		return ldapResponce;
	}
}