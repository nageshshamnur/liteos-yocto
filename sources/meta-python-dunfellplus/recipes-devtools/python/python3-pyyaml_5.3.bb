SUMMARY = "Python support for YAML"
DEPENDS += "libyaml ${PYTHON_PN}-cython-native"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a76b4c69bfcf82313bbdc0393b04438a"

PYPI_PACKAGE = "PyYAML"

inherit pypi setuptools3

SRC_URI[sha256sum] = "e9f45bd5b92c7974e59bcd2dcc8631a6b6cc380a904725fce7bc08872e691615"

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-netclient \
"

BBCLASSEXTEND = "native nativesdk"
