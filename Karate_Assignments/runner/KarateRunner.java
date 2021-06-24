package runner;

import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;

@KarateOptions(features="src/main/java/features/CreateAndDelete.feature")
@RunWith(Karate.class)
public class KarateRunner {

}
