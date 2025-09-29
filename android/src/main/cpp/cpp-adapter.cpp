#include <jni.h>
#include "TiktokEventSdkOnLoad.hpp"

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void*) {
  return margelo::nitro::tiktokeventsdk::initialize(vm);
}
