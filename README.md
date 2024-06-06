# dump-webhook-data

A simple spring boot application, exposing a post endpoint, and dumping the body into a file. Used in association with ngrok to test how webhooks defined on some services (slack, Linear, ...) are working.

## Usage

To launch the app:
 ```bash
 mvn spring-boot:run
 ```

*Note.* This app use Maven 3.9 and Java 21.

To request the endpoint 

```bash
curl -XPOST localhost:8080/ -H "Content-type: application/json" -d'{"hello":"world"}'
# A file dump_<timestamp>.json containing {"hello":"world"} is created on src/main/resources
```

With `<timestamp>` the timestamp (`long`) in seconds corresponding to the moment where data are dumped in the file.

For a content-type different that `application/json`, it will by default write the data in the file as a string, with the extension `.txt`. For example:
```bash
curl -XPOST localhost:8080/ -H "Content-type: text/plain" -d'{"hello":"world"}'
# A file dump_<timestamp>.txt containing "{\"foo\": \"bar\"}" is created on src/main/resources
```
