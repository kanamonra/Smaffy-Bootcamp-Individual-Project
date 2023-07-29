#include <WiFi.h>
#include <WiFiClient.h>
#include <WebServer.h>
#include "oled_u8g2.h" // oled display

const char* ssid = "U+NetA4EC";
const char* password = "31DH212#B9";

OLED_U8G2 oled; // create oled object
WebServer server(80);  // create WebServer object, port

int tempSensor = A2; // temperature sensor
// formula
int Vo;
double R1 = 10000;
double logR2, R2, T, Tc;
double c1 = 1.009249522e-03, c2 = 2.378405444e-04, c3 = 2.019202697e-07;
double Tf = 0;

void setup(void) {
  Serial.begin(115200);  // ESP32 baud rate
  oled.setup();
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  Serial.println("");
  
  while (WiFi.status() != WL_CONNECTED) { // wait for connection
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to ");
  Serial.println(ssid);
  Serial.print("IP addr: ");
  Serial.println(WiFi.localIP()); // print assigned ip address

  server.on("/", handleRootEvent);  // root, event handling function

  server.begin();
  Serial.println("Web server started!");
}

void loop(void) {
  oled.setLine(1, "Smaffy");
  oled.setLine(2, "Web Server");
  oled.display();

  server.handleClient();  // clients process
  delay(5); // 5/1000 sec
}

void handleRootEvent() {
  Serial.print("Main page from ");

  String clientIP = server.client().remoteIP().toString();  // client's ip addr.
  size_t lastDotPos = clientIP.lastIndexOf('.');
  String firstTwoParts = clientIP.substring(0, lastDotPos);
  
  // Blind the last four parts by replacing them with "xxx.xxx"
  String hiddenclientIP = firstTwoParts + ".xxx";

  Vo = analogRead(tempSensor); // read from temperature sensing value
  R2 = R1 * (4095.0 / (float)Vo - 1.0);
  logR2 = log(R2);
  T = (1.0 / (c1 + c2*logR2 + c3*logR2*logR2*logR2));
  Tc = T - 273.15;  // celsius
  Tf = (Tc * 9.0/5.0) + 32.0;  // fahrenheit

  String message = "Welcome to Demo Smart Factory Web Server!\n\n";
  message += "Your IP address: " + hiddenclientIP;  // Display hidden IP
  message = message + "\nTemperature: " + String(Tc) + "C " + "(" + String(Tf) + "F)";
  server.send(200, "text/plain", message);  // status code 200(OK), format, message

  Serial.println(clientIP);
  Serial.print(Tc);
  Serial.print("C (");
  Serial.print(Tf);
  Serial.println("F)");
}