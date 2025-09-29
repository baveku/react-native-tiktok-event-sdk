import { type HybridObject } from 'react-native-nitro-modules'

export interface TiktokEventSdk
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {
  initialSdk(
    accessToken: string,
    appId: string,
    tiktokAppId: string
  ): Promise<boolean>
  identifyUser(
    userId: string,
    userName?: string,
    phone?: string,
    email?: string
  ): void
  logout(): void
  trackEvent(event: string, params?: Record<string, string>): void
}
