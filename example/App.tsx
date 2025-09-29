import React from 'react';
import { Platform, StyleSheet, Text, View } from 'react-native';
import { TiktokEventSdk } from 'react-native-tiktok-event-sdk';
if (Platform.OS === 'ios') {
  TiktokEventSdk.initialSdk(
    'TTN38PulBWAiERdmsoJHp0jlg73UUkN3',
    '6740604289',
    '7519716348801417224',
  )
    .then(isInitial => {
      console.log('isInitial', isInitial);
    })
    .catch(error => {
      console.log('error', error);
    });
} else {
}
function App(): React.JSX.Element {
  return (
    <View style={styles.container}>
      <Text style={styles.text}></Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  text: {
    fontSize: 40,
    color: 'green',
  },
});

export default App;
