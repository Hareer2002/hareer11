import 'package:flutter/material.dart';
import '../utils/hareer_colors.dart';
import '../utils/hareer_strings.dart';

class HareerLoginScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: HareerColors.backgroundColor,
      extendBodyBehindAppBar: true, // السماح بتمديد الخلفية خلف الشريط العلوي
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Center(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                // العنوان
                Text(
                  HareerStrings.loginTitle,
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                    color: HareerColors.textColor,
                  ),
                  textAlign: TextAlign.center,
                ),
                SizedBox(height: 10),
                Text(
                  HareerStrings.loginSubtitle,
                  style: TextStyle(
                    fontSize: 16,
                    color: HareerColors.textColor.withOpacity(0.7),
                  ),
                  textAlign: TextAlign.center,
                ),
                SizedBox(height: 40),

                // حقل البريد الإلكتروني
                TextField(
                  decoration: InputDecoration(
                    hintText: HareerStrings.emailHint,
                    prefixIcon: Icon(Icons.email, color: HareerColors.primaryColor),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(12),
                      borderSide: BorderSide(color: HareerColors.primaryColor),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(12),
                      borderSide: BorderSide(color: HareerColors.primaryColor, width: 2),
                    ),
                  ),
                ),
                SizedBox(height: 16),

                // حقل كلمة المرور
                TextField(
                  obscureText: true,
                  decoration: InputDecoration(
                    hintText: HareerStrings.passwordHint,
                    prefixIcon: Icon(Icons.lock, color: HareerColors.primaryColor),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(12),
                      borderSide: BorderSide(color: HareerColors.primaryColor),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(12),
                      borderSide: BorderSide(color: HareerColors.primaryColor, width: 2),
                    ),
                  ),
                ),
                SizedBox(height: 40),

                // الزر مع الظل
                ElevatedButton(
                  onPressed: () {},
                  style: ElevatedButton.styleFrom(
                    backgroundColor: HareerColors.primaryColor,
                    shadowColor: Colors.black.withOpacity(0.2),
                    elevation: 5, // ارتفاع الظل
                    padding: EdgeInsets.symmetric(vertical: 16),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(12),
                    ),
                  ),
                  child: Text(
                    HareerStrings.loginButton,
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
                SizedBox(height: 16),

                // زر التسجيل
                TextButton(
                  onPressed: () {},
                  child: Text(
                    HareerStrings.registerButton,
                    style: TextStyle(
                      color: HareerColors.primaryColor,
                      fontSize: 16,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
