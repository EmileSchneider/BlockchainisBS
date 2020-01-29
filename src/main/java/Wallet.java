import java.security.*;
import java.util.ArrayList;

public class Wallet {
    ArrayList<KeyBunlde> keychain = new ArrayList<KeyBunlde>();

    public void generateKeypair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");

        KeyPair pair = kpg.generateKeyPair();
        kpg.initialize(4096);
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();
git
    }
}

private enum KeyBunlde {
    PrivateKey,
    PublicKey
}