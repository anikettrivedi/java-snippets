package bloggingutilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonToBlogTextFileConvertor {

    private static final String ARTICLE_SEPARATOR = "\n################ ARTICLE NUMBER = %s ################\n";

    public static void main(String[] args) throws IOException {

        String jsonArrayStr = String.join("", Files.readAllLines(Paths.get("/Users/aniket/Files/github/anikettrivedi.github.io/blog/static-json/about.json")));
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        List<String> textFileList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            textFileList.add(String.format(ARTICLE_SEPARATOR, i));

            jsonObject.keys().forEachRemaining(
                    key -> {
                        Object object = jsonObject.get(key);
                        if (object instanceof String) {
                            textFileList.add(String.format("@%s %s", key, object));
                        } else if (object instanceof JSONArray) {
                            textFileList.add(String.format("@start%s", key));
                            JSONArray jsonArrayInner = (JSONArray) object;
                            for (int j = 0; j < jsonArrayInner.length(); j++) {
                                JSONObject jsonObjectInner = jsonArrayInner.getJSONObject(j);
                                textFileList.add(String.format("\t@%s", "entry"));
                                jsonObjectInner.keys().forEachRemaining(innerKey -> {
                                    Object objectInner = jsonObjectInner.get(innerKey);
                                    textFileList.add(String.format("\t\t@%s %s", innerKey, objectInner));
                                });
                            }
                            textFileList.add(String.format("@end%s", key));
                        }
                    }
            );
        }

        textFileList.forEach(System.out::println);

    }

}
