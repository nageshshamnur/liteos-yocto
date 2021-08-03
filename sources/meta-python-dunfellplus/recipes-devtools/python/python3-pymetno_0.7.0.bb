LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/source/p/pymetno/PyMetno-${PV}.tar.gz"

S = "${WORKDIR}/PyMetno-${PV}"

SRC_URI[sha256sum] = "a2508346b8be05b8d34a214e78726da0627af71b5665de7bdac431df542be196"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-aiohttp (>=3.6.1) \
	${PYTHON_PN}-async-timeout (>=3.0.1) \
	${PYTHON_PN}-pytz (>=2019.3) \
"
