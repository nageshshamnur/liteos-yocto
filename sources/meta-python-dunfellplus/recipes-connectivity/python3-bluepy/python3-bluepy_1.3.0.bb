SUMMARY = "Python module for interfacing with BLE devices through Bluez"
HOMEPAGE = "https://github.com/IanHarvey/bluepy"
AUTHOR = "Ian Harvey <website-contact@fenditton.org>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;md5=afacc6ee39f10b48e8e138ed3a6d59e0"

SRC_URI = " \
    https://files.pythonhosted.org/packages/27/91/6cfca10bee9862f93015413cf9e6a52c3081a71f1518963396a055128f8e/bluepy-1.3.0.tar.gz \
    file://fix-fakeroot-tar-x.patch \
    "
SRC_URI[md5sum] = "04b7412993e6a133ddc3a3a2fcc1bdde"
SRC_URI[sha256sum] = "2a71edafe103565fb990256ff3624c1653036a837dfc90e1e32b839f83971cec"

S = "${WORKDIR}/bluepy-1.3.0"

inherit setuptools3

DEPENDS += "\
    glib-2.0 \
"

TARGET_CC_ARCH += "${LDFLAGS}"
