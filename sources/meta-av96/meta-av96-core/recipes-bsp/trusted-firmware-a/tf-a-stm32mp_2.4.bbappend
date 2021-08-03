FILESEXTRAPATHS_prepend_stm32mp1-av96-common := "${THISDIR}/files:"

SRC_URI_append_stm32mp1-av96-common = " \
				file://0001-fdts-av96-fw-config.patch \
				"
