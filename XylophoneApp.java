import 'package:flutter/material.dart';
import 'package:audioplayers/audioplayers.dart';
import 'package:neopop/neopop.dart';
import 'package:neopop/utils/color_utils.dart';

void main() => runApp(const XylophoneApp());

void playSound(int noteNumber) {
  final player = AudioPlayer();
  player.play(AssetSource('note$noteNumber.wav'));
}

class XylophoneApp extends StatelessWidget {
  const XylophoneApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Column(
            children: [
              Expanded(
                child: XylophoneKey(noteNumber: 1, color: Colors.red),
              ),
              Expanded(
                child: XylophoneKey(noteNumber: 2, color: Colors.orange),
              ),
              Expanded(
                child: XylophoneKey(noteNumber: 3, color: Colors.yellow),
              ),
              Expanded(
                child: XylophoneKey(noteNumber: 4, color: Colors.lightGreen),
              ),
              Expanded(
                child: XylophoneKey(noteNumber: 5, color: Colors.green),
              ),
              Expanded(
                child: XylophoneKey(noteNumber: 6, color: Colors.blue),
              ),
              Expanded(
                child: XylophoneKey(noteNumber: 7, color: Colors.indigo),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class XylophoneKey extends StatelessWidget {
  final int noteNumber;
  final Color color;

  // Define the missing variables here
  static const kButtonAnimationDuration = Duration(milliseconds: 300); // Example duration, adjust as needed
  static const kButtonDepth = 5.0; // Example depth, adjust as needed

  const XylophoneKey({
    required this.noteNumber,
    required this.color,
  });

  @override
  Widget build(BuildContext context) {
    return NeoPopButton(
      color: color,
      bottomShadowColor: ColorUtils.getVerticalShadow(color).toColor(),
      rightShadowColor: ColorUtils.getHorizontalShadow(color).toColor(),
      animationDuration: kButtonAnimationDuration,
      depth: kButtonDepth,
      onTapUp: () {
        playSound(noteNumber);
      },
      child: const Padding(
        padding: EdgeInsets.symmetric(horizontal: 20, vertical: 15),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("---------", style: TextStyle(color: Colors.white)),
          ],
        ),
      ),
    );
  }
}
