/*
 * Copyright 2012-2013 Brian Campbell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jose4j.jwe;

import junit.framework.TestCase;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.keys.ExampleRsaKeyFromJws;
import org.jose4j.lang.JoseException;

/**
 */
public class JsonWebEncryptionTest extends TestCase
{
    public void testTesting() throws JoseException
    {
        String plaintext = "{\"plain\":\"text\",\"a key\":\"with some value\",\"some:claim\":true}";
        JsonWebEncryption jwe = new JsonWebEncryption();        
        jwe.setPlaintext(plaintext);
        jwe.setAlgorithmHeaderValue(KeyManagementModeAlgorithmIdentifiers.RSA1_5);
        jwe.setKey(ExampleRsaKeyFromJws.PUBLIC_KEY);
        jwe.setHeader(HeaderParameterNames.ENCRYPTION_METHOD, EncryptionMethodAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);

        String jweCompactSerialization = jwe.getCompactSerialization();
    }
}
