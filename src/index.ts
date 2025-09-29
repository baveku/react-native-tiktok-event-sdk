import { NitroModules } from 'react-native-nitro-modules'
import type { TiktokEventSdk as TiktokEventSdkSpec } from './specs/tiktok-event-sdk.nitro'

export const TiktokEventSdk =
  NitroModules.createHybridObject<TiktokEventSdkSpec>('TiktokEventSdk')