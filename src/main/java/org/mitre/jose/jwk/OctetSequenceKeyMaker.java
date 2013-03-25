/**
 * 
 */
package org.mitre.jose.jwk;

import java.security.SecureRandom;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.Use;
import com.nimbusds.jose.util.Base64URL;

/**
 * @author jricher
 *
 */
public class OctetSequenceKeyMaker {

	/**
	 * @param keySize in bits
	 * @return
	 */
    public static JWK make(Integer keySize, Use use, Algorithm alg, String kid) {
    	
    	// holder for the random bytes
    	byte[] bytes = new byte[keySize / 8];
    	
    	// make a random number generator and fill our holder
    	SecureRandom sr = new SecureRandom();
    	sr.nextBytes(bytes);
    	
    	// make a key
    	Base64URL k = Base64URL.encode(bytes);
    	OctetSequenceKey key = new OctetSequenceKey(k, use, alg, kid);
    	
    	return key;
    	
    }

}