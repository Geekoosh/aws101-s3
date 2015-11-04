import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

public class Main {

    public static void main(String [] args) throws Exception {
        AWSCredentials credentials = new BasicAWSCredentials("AKIAIPJD73KB55CAPKKQ", "Sg1AXhuoyD3iLRfOMX4CnTNU5g3me2/HZXmtIpKz");
        AmazonS3Client amazonS3Client = new AmazonS3Client(credentials);
        URL url = new URL(args[0]);
        InputStream in = new BufferedInputStream(url.openStream());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpeg");
        PutObjectRequest putObjectRequest = new PutObjectRequest("wiseman-bucket-test", args[1], in, objectMetadata);
        putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
        PutObjectResult result = amazonS3Client.putObject(putObjectRequest);
        System.out.print(amazonS3Client.getResourceUrl("wiseman-bucket-test", args[1]));
    }
}
