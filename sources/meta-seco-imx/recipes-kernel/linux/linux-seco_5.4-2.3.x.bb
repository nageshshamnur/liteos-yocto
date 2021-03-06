SUMMARY = "Linux Kernel provided and supported by SECO"
DESCRIPTION = "Linux Kernel provided and supported by SECO with focus on \
SECO Boards. It includes support for many IPs such as GPU, VPU and IPU."


require recipes-kernel/linux/linux-imx.inc

include linux-seco-src-5.4.70.inc


DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
EXTRA_OEMAKE_append_mx6 = " ARCH=arm"
EXTRA_OEMAKE_append_mx8 = " ARCH=arm64"

KBUILD_DEFCONFIG_seco-imx8mm-c61 = "seco_imx8_linux_defconfig"


do_preconfigure_prepend() {
    install -d ${B}
    cp ${S}/arch/${ARCH}/configs/${KBUILD_DEFCONFIG} ${WORKDIR}/defconfig
}
