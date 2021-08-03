meta-seco-intel
===============

This README file contains information on building and booting
meta-seco-intel BSP layers.  Please see the corresponding sections below
for details.


Yocto Project Compatible
========================

The BSPs contained in this layer are compatible with the Yocto Project
as per the requirements listed here:

  https://www.yoctoproject.org/webform/yocto-project-compatible-registration


Tested Hardware
================

This layer has been tested with the following MACHINE variables:

  - `seco-intel-b68` (SBC-SECO-B68)


Dependencies
============

This layer depends on:

  URI: git://git.openembedded.org/bitbake
  branch: dunfell

  URI: git://git.openembedded.org/openembedded-core
  layers: meta
  branch: dunfell

  URI: git://git.yoctoproject.org/meta-intel
  layers: intel
  branch: master


Configuration
=============

1. Clone the `meta-seco-intel` layer to your project directory.
2. Add the `meta-seco-intel` layer to `conf/bblayers.conf`
```bitbake
	BBLAYERS += "path/to/meta-seco-intel"
```
3. Add dependency layers to `conf/bblayers.conf`
```bitbake
	BBLAYERS += "path/to/meta-intel"
```

4. Configure the variable MACHINE in your local.conf.
```bitbake
	MACHINE ?= "seco-corei7-64"
```
 or while using bitbake:
```
	MACHINE="seco-corei7-64" bitbake core-image-minimal
```


Credits
=======

Based on the `meta-intel` layer from [meta-intel][intel].

[intel]: https://git.yoctoproject.org/cgit/cgit.cgi/meta-intel/
