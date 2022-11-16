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

// Top-level conversion function. BigDecimal is returned to ensure currency precision.
// Doubles, Floats, and BigDecimal values are supported.
BigDecimal converted1 = api.convert("CAD", "USD", 69.0D);
BigDecimal converted2 = api.convert("CAD", "USD", 42.0f);
BigDecimal converted3 = api.convert("CAD", "USD", new BigDecimal("100"));
BigDecimal converted4 = api.convert(CurrencyList.EUR, CurrencyList.JPY, new BigDecimal("1457.25"));

// Check account status
StatusResponse status = api.getWrapper().getStatus();

// Get all currencies
CurrenciesResponse currencies = api.getWrapper().getCurrencies();

// Get specific currencies
CurrenciesResponse currencies = api.getWrapper().getCurrencies(CurrencyList.AUD, CurrencyList.CAD, CurrencyList.EUR, CurrencyList.USD);

// Get latest exchange rates
LatestResponse latest = api.getWrapper().getLatest();

// Get specific latest exchange rates
LatestResponse latestCadDef = api.getWrapper().getLatest(CurrencyList.CAD, CurrencyList.EUR);
```

For information on endpoints, please refer to [freecurrencyapi Documentation](https://freecurrencyapi.com/docs).

## Todo

- [ ] Caching
- [ ] Historical
- [ ] Helper functions
   - [x] Convert

[Image]: https://jitpack.io/v/tycrek/fcapi-java.svg?style=flat-square
[Jitpack]: https://jitpack.io/#tycrek/fcapi-java/
