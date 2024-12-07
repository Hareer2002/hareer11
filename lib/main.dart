import 'package:flutter/material.dart';
import 'screens/hareer_login_screen.dart';

void main() {
  runApp(HareerApp());
}

class HareerApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Hareer',
      theme: ThemeData(
        primaryColor: Colors.blue,
      ),
      home: HareerLoginScreen(),
    );
  }
}
