FILESEXTRAPATHS_prepend_stm32mp1-av96-common := "${THISDIR}/files:"

SRC_URI_append_stm32mp1-av96-common = " \
	file://0001-linux-ap1302.patch \
	file://0002-media-ov5640-reduce-mipi-rate-according-to-maximum-p.patch \
	file://0003-media-v4l2-add-support-of-pclk_max_frequency-on-CSI-.patch \
	file://0004-media-ov5640-add-the-support-of-the-auto-focus.patch \
	file://0005-Bluetooth-6lowpan-fix-direct-peer-to-peer-connection.patch \
	"

KERNEL_CONFIG_FRAGMENTS_append_stm32mp1-av96-common = " \
		${WORKDIR}/fragments/fragment-06-brcmfmac.config \
		${WORKDIR}/fragments/fragment-07-hdmi.config \
		${WORKDIR}/fragments/fragment-08-bt_sco.config \
		${WORKDIR}/fragments/fragment-09-tpm.config \
		${WORKDIR}/fragments/fragment-10-usb_ftdi.config \
		${WORKDIR}/fragments/fragment-11-ap1302.config \
		${WORKDIR}/fragments/fragment-12-fbdev.config \
		"

SRC_URI_append_stm32mp1-av96-common = " \
		file://fragment-06-brcmfmac.config;subdir=fragments \
		file://fragment-07-hdmi.config;subdir=fragments \
		file://fragment-08-bt_sco.config;subdir=fragments \
		file://fragment-09-tpm.config;subdir=fragments \
		file://fragment-10-usb_ftdi.config;subdir=fragments \
		file://fragment-11-ap1302.config;subdir=fragments \
		file://fragment-12-fbdev.config;subdir=fragments \
		"
