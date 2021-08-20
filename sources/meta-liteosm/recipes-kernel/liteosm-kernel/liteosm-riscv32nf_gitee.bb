# SPDX-FileCopyrightText: Huawei Inc.
#
# SPDX-License-Identifier: Apache-2.0
require liteosm-kernel-common.inc

SUMMARY = "QEMU target for Gitee LiteOS-M Kernel RISCV32 architecture"
DESCRIPTION = "Gitee LiteOS-M kernel is designed for microcontrollers with \
 active support for RISCV32 architecture. It also support QEMU for RISCV32\
 architecture. This receipe integrates the same All Scenarios OS. "
HOMEPAGE = "https://gitee.com/openharmony"
SECTION = "kernel"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://device_qemu/LICENSE;md5=98c2e72b17fae6c40fb14fd5e43b29ec"
DEPENDS = "libgcc newlib libgloss"
# No clang support until the build system is fixed
TOOLCHAIN = "gcc"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"


SRCREV_qemu = "3dd9df983a2161444dd057bc843e4963e0697acc"
SRCREV_liteosm = "6a57244291e41c0f2c45149636a2edfdbae62ce0"
SRCREV_boundsfn = "e25097d4fa5a0f0e2ed70859eda09b1ae256c182"

SRC_URI = "\
	  git://gitee.com/NageshShamnur/device_qemu.git;protocol=https;branch=standlone-liteosm;destsuffix=git/device_qemu;name=qemu\
	  git://gitee.com/NageshShamnur/kernel_liteos_m.git;protocol=https;destsuffix=git/kernel-liteos-m;name=liteosm\
	  git://gitee.com/openharmony/third_party_bounds_checking_function.git;protocol=https;destsuffix=git/third_party_bounds_checking_function;name=boundsfn\
	  "

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(baremetal-riscv32|baremetal-riscv32nf|qemuriscv32|qemuriscv32nf|qemuriscv64)"

IMAGE_FEATURES_append = " read-only-rootfs"

do_configure_prepend() {
	bb.plain(" PN: %s " % ${PN} );
	cd ${S}/device_qemu/riscv32_virt
	oe_runmake clean
}

do_compile() {
        # Use the correct toolchain
        TRIPLET=$(echo ${TARGET_PREFIX} |sed -e 's,-$,,')
        if [ "$TRIPLET" != "riscv32-unknown-elf" ]; then
                sed -i -e "s,riscv32-unknown-elf,$TRIPLET,g" ${S}/device_qemu/riscv32_virt/Makefile
        fi

        # Locate libgcc,libc and libgloss path and update in the makefile
        GCCVER="$(${TARGET_PREFIX}gcc --version |head -n1 |cut -d' ' -f3)"
        LIBGCC_PATH="${RECIPE_SYSROOT}/usr/lib/${TRIPLET}/${GCCVER}"
        sed -i -e "s|-lgcc|-L${LIBGCC_PATH} -lgcc|" ${S}/device_qemu/riscv32_virt/Makefile
	LIBC_PATH="${RECIPE_SYSROOT}/usr/lib"
        sed -i -e "s|-lc|-L${LIBC_PATH} -lc|" ${S}/device_qemu/riscv32_virt/Makefile

	export LITEOS_COMPILER_GCC_INCLUDE=" -I${RECIPE_SYSROOT}/usr/include"
        cd ${S}/device_qemu/riscv32_virt
        ##oe_runmake --trace
        make --trace
}

do_install[noexec] = "1"

do_deploy () {
    install -D ${B}/device_qemu/riscv32_virt/out/OHOS_Image ${DEPLOYDIR}/bzImage
}
addtask deploy after do_compile

