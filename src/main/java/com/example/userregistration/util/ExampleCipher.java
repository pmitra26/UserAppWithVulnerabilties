package com.example.userregistration.util;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import java.security.NoSuchAlgorithmException;

public class ExampleCipher {


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher ci = new NullCipher();

        // EMB-ISSUE: CodeIssueNames.AVOID_NULL_CIPHER
        Cipher c7 = NullCipher.getInstance("AES");


        // EMB-ISSUE: CodeIssueNames.AVOID_NULL_CIPHER/no-detect
        Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
    }
}
