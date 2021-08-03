# meta-python-dunfellplus

## Introduction

This layer is intended to be an extension to the meta-python dunfell branch. This is because dunfell is an LTS version and more projects, with various python modules requirements will levitate more on this version. This layer will provide additional modules, additional versions or various other functionality backported from meta-python master.

The aim of this is to minimise duplication on python recipes backporting on other layers. For example, meta-homeassistant.

## Dependencies

The meta-python-dunfellplus layer depends on:

* URI: git://git.openembedded.org/openembedded-core
  * layers: meta
  * branch: dunfell
  * revision: HEAD
* URI: git://git.openembedded.org/meta-openembedded
  * layers: meta-oe
  * branch: dunfell
  * revision: HEAD
* URI: git://git.openembedded.org/meta-openembedded
  * layers: meta-python
  * branch: dunfell
  * revision: HEAD

Please follow the recommended setup procedures of your OE distribution.

## Contributing

Contributions to this layer are to be handled as merge requests in the Gitlab instance where the layer is hosted: https://git.ostc-eu.org/OSTC/OHOS/meta-python-dunfellplus.

## Maintenance

Maintainers: Andrei Gherzan <andrei.gherzan@huawei.com>

## License

See the `LICENSES` subdirectory.
