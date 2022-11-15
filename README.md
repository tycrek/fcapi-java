<div align="center">

FcApi Java
===

[![Image]][Jitpack]

*A Java wrapper for freecurrencyapi.com.*

</div>

## Installation

FcApi is available from [Jitpack]:

### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.tycrek:fcapi-java:_version_'
}
```

## Usage

[Register for a free account](https://app.freecurrencyapi.com/register) to get an API key.

```java
FcApi api = new FcApi(API_KEY);

// Check account status
StatusResponse status = api.getStatus();

// Get all currencies
CurrenciesResponse currencies = api.getCurrencies();

// Get specific currencies
CurrenciesResponse currencies = api.getCurrencies(CurrencyList.AUD, CurrencyList.CAD, CurrencyList.EUR, CurrencyList.USD);

// Get latest exchange rates
LatestResponse latest = api.getLatest();

// Get specific latest exchange rates
LatestResponse latestCadDef = api.getLatest(CurrencyList.CAD, CurrencyList.EUR);
```

For information on endpoints, please refer to [freecurrencyapi Documentation](https://freecurrencyapi.com/docs).

## Todo

- [ ] Caching
- [ ] Historical
- [ ] Helper functions

[Image]: https://jitpack.io/v/tycrek/fcapi-java.svg?style=flat-square
[Jitpack]: https://jitpack.io/#tycrek/fcapi-java/
