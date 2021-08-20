require conf/machine/include/riscv/tune-riscv.inc
require conf/machine/include/riscv/qemuboot-riscv32.inc

KERNEL_IMAGETYPE = "bzImage"
QB_DEFAULT_KERNEL = "bzImage"

MACHINE_FEATURES = "vfat"

MACHINEOVERRIDES =. "qemuall:"

MACHINE_FEATURES = "vfat"

IMAGE_FSTYPES += "ext4"

EXTRA_IMAGEDEPENDS += "qemu-system-native qemu-helper-native"

IMAGE_CLASSES += "qemuboot"

inherit core-image

# qemuboot options
IMAGE_CLASSES += "qemuboot"
QB_SYSTEM_NAME = "qemu-system-riscv32"
QB_MACHINE = "-machine virt"
QB_CPU = "-cpu riscv32nf"
QB_MEM = "-m 128"
QB_KERNEL_CMDLINE_APPEND = "root=dev/vda or console=ttyS0"

SERIAL_CONSOLES ?= "ttyS0"
SERIAL_CONSOLES_CHECK = "${SERIAL_CONSOLES}"
