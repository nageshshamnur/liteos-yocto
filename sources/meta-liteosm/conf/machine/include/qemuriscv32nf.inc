require conf/machine/include/riscv/tune-riscv.inc
require conf/machine/include/riscv/qemuboot-riscv32.inc

IMAGE_PKGTYPE = "rpm"

#LITEOSM_CLASS_INCLUDE = "core-image liteosm-qemuboot"
LITEOSM_CLASS_INCLUDE = "liteosm-qemuboot"
inherit ${LITEOSM_CLASS_INCLUDE}

KERNEL_IMAGETYPE = "${PN}.elf"
QB_DEFAULT_KERNEL = "${PN}.elf"

#MACHINE_FEATURES = "vfat"

MACHINEOVERRIDES =. "qemuall:"


EXTRA_IMAGEDEPENDS += "qemu-system-native qemu-helper-native"

# qemuboot options
QB_SYSTEM_NAME = "qemu-system-riscv32"
QB_MACHINE = "-machine virt"
QB_CPU = "-cpu rv32"
QB_MEM = "-m 128"
QB_KERNEL_CMDLINE_APPEND = "root=dev/vda or console=ttyS0"

SERIAL_CONSOLES ?= "ttyS0"
SERIAL_CONSOLES_CHECK = "${SERIAL_CONSOLES}"
